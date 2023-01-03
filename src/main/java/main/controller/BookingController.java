package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.entity.*;
import main.implementation.*;
import main.util.Constants;
import main.util.Helper;

import org.hibernate.*;

import com.fasterxml.jackson.core.JsonProcessingException;
@Controller
public class BookingController {
	private StoreRepository storeRepository = StoreRepository.getInstance();
	private TypeServiceRepository typeServiceRepository = TypeServiceRepository.getInstance();
	private ServiceRepository serviceRepository = ServiceRepository.getInstance();
	private ShiftRepository shiftRepository = ShiftRepository.getInstance();
	private StaffRepository staffRepository = StaffRepository.getInstance();
	private BookRepository bookRepository = BookRepository.getInstance();
	private BookItemRepository bookItemRepository = BookItemRepository.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Gson gson = new Gson();
	@Autowired
	SessionFactory factory;
	@RequestMapping("/booking")
	public String main(@RequestParam("phone") String phone,
						@RequestParam("storeId") String storeId,
						@RequestParam("step") int step,
						HttpSession httpSession,
						HttpServletRequest request,
						ModelMap model) {
		String layout = "";
		Session session = factory.openSession();
		String rawServiceIds = request.getParameter("serviceIds");
		switch (step) {
			case 0:
				
				List <Store> storeById = this.storeRepository.find("WHERE IDStore = " + storeId, session);
				List <Shift> shifts = this.shiftRepository.find("", session);
				String streetName = storeById.size() == 0 ? "Xem tất cả salon" : storeById.get(0).getStreet();
				String titleService = "Xem tất cả dịch vụ hấp dẫn";
				if (httpSession.getAttribute("titleService") != null) {
					titleService = (String) httpSession.getAttribute("titleService");
				}
				layout = "booking/index.jsp";
				if (rawServiceIds != null) {
					List<Service> servicesBooked = this.serviceRepository.find("WHERE IDService in (" + rawServiceIds + ")", session);
					titleService = "Đã chọn " + servicesBooked.size() + " dịch vụ";
					Calendar calendar = Calendar.getInstance();
					Date currentDate = new Date();
					calendar.setTime(currentDate);
					List<Staff> rawStaffsInDate1 = staffRepository.findStaffByDateRegis(currentDate, storeId, session);
					calendar.add(Calendar.DATE, 1);
					List<Staff> rawStaffsInDate2 = staffRepository.findStaffByDateRegis(calendar.getTime(),storeId, session);
					calendar.add(Calendar.DATE, 1);
					List<Staff> rawStaffsInDate3 = staffRepository.findStaffByDateRegis(calendar.getTime(), storeId, session);
					calendar.add(Calendar.DATE, 1);
					List<Staff> rawStaffsInDate4 = staffRepository.findStaffByDateRegis(calendar.getTime(), storeId, session);
					calendar.add(Calendar.DATE, 1);
					List<Staff> rawStaffsInDate5 = staffRepository.findStaffByDateRegis(calendar.getTime(), storeId, session);
					calendar.add(Calendar.DATE, 1);
					List<Staff> rawStaffsInDate6 = staffRepository.findStaffByDateRegis(calendar.getTime(), storeId, session);
					
					// get book in date
					String startDate = sdf.format(currentDate);
					String endDate = sdf.format(calendar.getTime());
					String queryBookedInDate = "WHERE dateBook between '" + startDate +  "' and '" + endDate + "'";
					List<Book> rawBookedInDates = bookRepository.find(queryBookedInDate, session);
					
					try {
						ObjectMapper mapper = new ObjectMapper();
						String staffsInDate1 = mapper.writeValueAsString(rawStaffsInDate1);
						String staffsInDate2 = mapper.writeValueAsString(rawStaffsInDate2);
						String staffsInDate3 = mapper.writeValueAsString(rawStaffsInDate3);
						String staffsInDate4 = mapper.writeValueAsString(rawStaffsInDate4);
						String staffsInDate5 = mapper.writeValueAsString(rawStaffsInDate5);
						String staffsInDate6 = mapper.writeValueAsString(rawStaffsInDate6);
						String bookedInDates = mapper.writeValueAsString(rawBookedInDates);
						String jsonServicesBooked = mapper.writeValueAsString(servicesBooked);
						
						httpSession.setAttribute("jsonServicesBooked", jsonServicesBooked);
						model.addAttribute("staffsInDate1", staffsInDate1);
						model.addAttribute("staffsInDate2", staffsInDate2);
						model.addAttribute("staffsInDate3", staffsInDate3);
						model.addAttribute("staffsInDate4", staffsInDate4);
						model.addAttribute("staffsInDate5", staffsInDate5);
						model.addAttribute("staffsInDate6", staffsInDate6);
						model.addAttribute("bookedInDates", bookedInDates);
					} catch (JsonProcessingException e) {
						System.out.println("excep: "  + e);
					}
					
					
					httpSession.setAttribute("servicesBooked", servicesBooked);
				}
				
				String rawShifts = gson.toJson(shifts);
				
				httpSession.setAttribute("titleService", titleService);
				model.addAttribute("streetName", streetName);
				model.addAttribute("shifts", rawShifts);
				break;
			case 1:
				layout = "booking/salon.jsp";
				List <Store> stores = storeRepository.find("", session);
				model.addAttribute("stores", stores);
				break;
			case 2: 
				layout = "booking/service.jsp";
				List <TypeService> categories = this.typeServiceRepository.find("", session);
				List <Service> rawServices = this.serviceRepository.find("", session);
				String rootUrl = request.getRequestURL().toString() + "?" + request.getQueryString();;
				String services = new Gson().toJson(rawServices);
				
				
				model.addAttribute("categories", categories);
				model.addAttribute("services", services);
				model.addAttribute("rootUrl", rootUrl);
				break;
		}
		
		
		
		model.addAttribute("layout", layout);
		return "";
	}
	
	@RequestMapping("/booking/success")
	String finishBooking(ModelMap model, HttpServletRequest request, HttpSession httpSession) {
		Session session = factory.openSession();
		String dateBook = request.getParameter("dateBook");
		String payment = request.getParameter("payment");
		String phoneBook = request.getParameter("phoneBook");
		String servicesChoose = request.getParameter("servicesChoose");
		String idShift = request.getParameter("idShiftBook");
		String idStaff = request.getParameter("staffBook");
		String idStore = request.getParameter("storeBook");
		String timeChoose = request.getParameter("timeChoose");
		String streetStore = request.getParameter("streetStore");
		List<Service> servicesBooked = (List<Service>) httpSession.getAttribute("servicesBooked");

		this.preprocessBook(session, phoneBook);
		Book book = this.generateBook(dateBook, idShift, idStaff, payment, phoneBook, idStore, Constants.BOOKED);
		List<BookItem> bookItems = this.generateBookItem(servicesBooked, book);
		
		Boolean isInsertBook = this.bookRepository.save(book, session);
		Boolean isInsertListBookItem = this.bookItemRepository.insertMany(bookItems, session);
		
		if (isInsertBook && isInsertListBookItem) {
			httpSession.removeAttribute("titleService");
			httpSession.removeAttribute("servicesBooked");
			httpSession.removeAttribute("jsonServicesBooked");
			System.out.println("Booking successfully");
		}
		
		Staff staff = this.staffRepository.findById(idStaff, session);

		model.addAttribute("phoneBook", phoneBook);
		model.addAttribute("streetStore", streetStore);
		model.addAttribute("timeChoose", timeChoose);
		model.addAttribute("fullName", staff.getSurName() + " " + staff.getNameStaff());
		model.addAttribute("pathImgStaff", staff.getPathImgStaff());
		model.addAttribute("payment", payment);
		model.addAttribute("dateBook", dateBook);
		model.addAttribute("idShiftBook", idShift);
		model.addAttribute("idStaffBook", idStaff);
		model.addAttribute("servicesChoose", servicesChoose);
		model.addAttribute("dayOfWeek", Helper.getDayOfWeek(dateBook));
		model.addAttribute("monthOfYear", Helper.getDayOfMonth(dateBook) + "." + Helper.getMonthOfYear(dateBook));
		
		model.addAttribute("layout", "booking/booking_done.jsp");
		return "";
	}
	
	private void preprocessBook(Session session, String phoneCus) {
		Book existBook = this.bookRepository.findByPhoneAndStatus(phoneCus, Constants.BOOKED, session);
		if (existBook == null) {
			System.out.println("Not existed for this book");
			return;
		}

		BookItem bookItem = this.bookItemRepository.findOne("", session);		
		int matchedRemoveBookItem = this.bookItemRepository.deleteByField(existBook.getDateBook(),existBook.getIdShiftBook(), existBook.getIdStaff(), session);
		int matchedRemoveBook = this.bookRepository.deleteByField(existBook.getDateBook(),existBook.getIdShiftBook(), existBook.getIdStaff(), session);
		
		if (matchedRemoveBookItem > 0 && matchedRemoveBook == 1) {
			System.out.println("Preprocess successfully");
		}
	}
	
	private Book generateBook(String dateString, String idShiftBook, String idStaff,
							  String payment, String phoneCus, 
							  String idStore, String status) {
		Date dateParse = Helper.convertStringToDate(dateString, Constants.FORMAT_DATE);
		int paymentParse = Integer.valueOf(payment);
		int idStoreParse = Integer.valueOf(idStore);
		
		Book book = new Book(dateParse, idShiftBook, idStaff, paymentParse, phoneCus, idStoreParse, status);
		
		return book;
	}
	
	private List<BookItem> generateBookItem(List<Service> services, Book book) {
		List<BookItem> listBookItem = new ArrayList<>();
		for (Service service: services) {
			BookItem bookItem = new BookItem(book.getDateBook(), book.getIdShiftBook(), 
					book.getIdStaff(), service.getIdService(), service.getPrice());
			listBookItem.add(bookItem);
		}
		
		return listBookItem;
	}
	
	@RequestMapping("/cancel")
	private String cancelBooking(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		String phoneBook = request.getParameter("phoneBook");
		Session session = factory.openSession();
		try {
			this.preprocessBook(session, phoneBook);
			response.sendRedirect("index.htm");			
		} catch (IOException e) {
			
		}
		return "";
	}
}
