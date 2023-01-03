package main.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import main.entity.*;
import main.implementation.*;
import main.util.Constants;
import main.util.Helper;
import poly.controller.PayloadAuthen;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;

@Controller
@RequestMapping("/user")
public class AuthenticationController {

	@Autowired
	SessionFactory factory;
	
	@Autowired
	JavaMailSender mailer;

	private AccountRepository accountRepository = AccountRepository.getInstance();
	private CustomerRepository customerRepository = CustomerRepository.getInstance();
	private ShiftRepository shiftRepository = ShiftRepository.getInstance();
	private StaffRepository staffRepository = StaffRepository.getInstance();
	private BookRepository bookRepository = BookRepository.getInstance();
	@Transactional
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String login(HttpServletResponse response, @RequestBody PayloadAuthen payload
							) {
		Session session = factory.openSession();
		String account = payload.getAccount();
		String password = payload.getPassword();
		Map<String, Object> map = new HashMap<>();
		try {
			TaiKhoan tk = this.accountRepository.findByIdAndActive(account, session);
			String originPass = tk.getPassword();
			Boolean isMatchPassword = BCrypt.checkpw(password, originPass);
			if (isMatchPassword) {
				Customer customer = this.customerRepository.findByPhone(account, session);
				map.put("status", "success");
				String token = this.generateToken(customer.getPhoneCustomer(), customer.getNameCustomer(), tk.getRole());
				payload.setAccessToken(token);
				payload.setNameCustomer(customer.getNameCustomer());
				payload.setPhone(account);
				payload.setPassword(null);
				map.put("elements", payload);
			} else {
				map.put("status", "failed");
			}
		} catch (Exception e) {
			map.put("status", "failed");
		}
		String json = new Gson().toJson(map);
		return json;
	}
	
	@Transactional
	@RequestMapping(value = "/verify-token", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	String verifyToken(@RequestBody PayloadAuthen payload, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		String accessToken = payload.getAccessToken();
		try {
			Jwt jwtObject = Jwts.parser().setSigningKey(Constants.SECRET_KEY_ACCESS_TOKEN.getBytes()).parseClaimsJws(accessToken);
			String body = jwtObject.getBody().toString().replace("=", ":");
			JSONObject jsonObject = new JSONObject(body);
			
			String accountId = jsonObject.getString("accountId");
			String nameCustomer = jsonObject.getString("nameCustomer");
			map.put("phoneCustomer", accountId);
			map.put("nameCustomer", nameCustomer);
			map.put("status", "success");
		} catch (Exception e) {
			map.put("status", "failed");
		}
		String json = new Gson().toJson(map);
		return json;
	}
	
	@Transactional
	@RequestMapping(value = "/regis/check-duplicate", method = RequestMethod.POST)
	@ResponseBody
	public String checkDuplicate(HttpServletResponse response, @RequestBody PayloadAuthen payload
							) {
		Session session = factory.openSession();
		String status = "Not found";
		switch (payload.getReferenceDuplicate()) {
		case "ACCOUNT":
			TaiKhoan tkByAccount = this.accountRepository.findById(payload.getPhone(), session);
			if (tkByAccount != null) {
				status = "Found";
			}
			break;
		case "EMAIL":
			Customer customer = this.customerRepository.findByEmail(payload.getEmail(), session);
			if (customer != null) {
				status = "Found";
			}
			break;
		default:
			status = "ERROR";
			break;
		}
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("status", status);
		
		String json = new Gson().toJson(map);
		
		return json;
	}
	
	@Transactional
	@RequestMapping(value = "/regis/verify-email", method = RequestMethod.POST)
	@ResponseBody
	String verifyEmail(HttpSession httpSession, @RequestBody PayloadAuthen payload) {
		Session session = factory.openSession();
		Map<String, String> map = new HashMap<>();
		String originNumber = (String) httpSession.getAttribute("verifyNumber");
		String clientNumber = payload.getVerifyNumber();
		if (!originNumber.equals(clientNumber)) {
			map.put("status", "Failed verify");
			String json = new Gson().toJson(map);
			return json;
		}
		
		String hashedPassword = BCrypt.hashpw(payload.getPassword(), BCrypt.gensalt());
		TaiKhoan tk = new TaiKhoan(payload.getPhone(), hashedPassword, Constants.STATUS_ACTIVE_ACCOUNT, "1");
		Customer customer = new Customer(payload.getPhone(), payload.getNameCustomer(), payload.getEmail(), new Date());
		Boolean isInsertAccount = this.accountRepository.save(tk, session);
		Boolean isInsertCustomer = this.customerRepository.save(customer, session);
		
		if (isInsertAccount && isInsertCustomer) {
			String token = this.generateToken(customer.getPhoneCustomer(), customer.getNameCustomer(), tk.getRole());
			System.out.println("Create new customer successfully");
			map.put("token", token);
			map.put("status", "success");
			map.put("phoneCustomer", "0879229094");
			String json = new Gson().toJson(map);
			return json;
		}
		
		return "failed";
	}
	
	@Transactional
	@RequestMapping(value = "/info-booking", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	String getInfoBooking(@RequestBody PayloadAuthen payload) {
		Session session = factory.openSession();
		Map<String, Object> map = new HashMap<>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			String phoneCus = payload.getPhone();
			Book book = this.bookRepository.findBookNew(phoneCus, session);
			if (book != null) {
				Staff staff = this.staffRepository.findById(book.getIdStaff(), session);
				Shift shift = this.shiftRepository.findById(book.getIdShiftBook(), session);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(book.getDateBook());
				String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("vi", "VN"));
				map.put("status_info", "success");
				map.put("dayOfWeek", dayOfWeek);
				map.put("street", staff.getStore().getStreet());
				map.put("dateBook", book.getDateBook());
				map.put("minuteBook", shift.getMinuteStart());
				map.put("hourBook", shift.getHourStart());
				map.put("nameStaff", staff.getSurName() + " " + staff.getNameStaff());
				String json = mapper.writeValueAsString(map);
				return json;
				
			}
			
		} catch (Exception e) {
			
		}
		String json = new Gson().toJson(map);
		return json;
	}
	
	@Transactional
	@RequestMapping(value = "/send-mail-forgot-password", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	String sendMailForgotPassword(@RequestBody PayloadAuthen payload, HttpSession httpSession) {
		String email = payload.getEmail();
		String verifyNumber = Helper.generateRandomSixNumber();
		String bodyVerifyMessage = Constants.TEXT_FORGOT_PASSWORD.replace("{verifyNumber}", verifyNumber);
		System.out.print("verify: " + verifyNumber);
		Helper.sendMail(mailer, email, Constants.SUBJECT_FORGOT_PASSWORD, bodyVerifyMessage);
		httpSession.setAttribute("verifyNumber", verifyNumber);
		Map<String, Object> map = new HashMap<>();
		map.put("status", "sucesss");
		String json = new Gson().toJson(map);
		return json;
	}
	
	@Transactional
	@RequestMapping(value = "/verify-forgot-pass", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	String verifyForgotPassword(@RequestBody PayloadAuthen payload, HttpSession httpSession) {
		Map<String, String> map = new HashMap<>();
		String originNumber = (String) httpSession.getAttribute("verifyNumber");
		String clientNumber = payload.getVerifyNumber();
		String status = "failed";
		if (originNumber.equals(clientNumber)) {
			status = "success";
		}
		map.put("status", status);
		String json = new Gson().toJson(map);
		return json;
	}
	
	@Transactional
	@RequestMapping(value = "/modify-password", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	String updatePassword(@RequestBody PayloadAuthen payload, HttpSession httpSession) {
		Map<String, Object> map = new HashMap<>();
		Session session = factory.openSession();
		String hashedPassword = BCrypt.hashpw(payload.getPassword(), BCrypt.gensalt());
		Customer customer = this.customerRepository.findByEmail(payload.getEmail(), session);
		String status = "failed";
		if (customer != null) {
			TaiKhoan tk = this.accountRepository.findById(customer.getPhoneCustomer(), session);
			tk.setPassword(hashedPassword);
			Boolean isUpdate = this.accountRepository.update(tk, session);
			if (isUpdate) {
				status = "success";
				map.put("status", "success");
				String token = this.generateToken(customer.getPhoneCustomer(), customer.getNameCustomer(), tk.getRole());
				payload.setAccessToken(token);
				payload.setNameCustomer(customer.getNameCustomer());
				payload.setPhone(tk.getAccount());
				payload.setPassword(null);
				map.put("elements", payload);
			}
		}
		
		map.put("status", status);
		String json = new Gson().toJson(map);
		return json;
	}
	
	String generateToken(String phoneCus, String nameCus, String role) {
		Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.MONTH, 1);
		String jwt = Jwts.builder()
		        .setExpiration(calendar.getTime())
		        .claim("accountId", phoneCus)
		        .claim("nameCustomer", nameCus)
		        .claim("role", role)
		        .signWith(SignatureAlgorithm.HS256, Constants.SECRET_KEY_ACCESS_TOKEN.getBytes())
		        .compact();
		
		return jwt;
	}
 }