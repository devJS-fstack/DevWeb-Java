package main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.entity.*;
import main.util.Constants;
import main.util.Helper;

@Controller
public class HomeController {

	@Autowired
	SessionFactory factory;
	
	@Autowired
	JavaMailSender mailer;

	@RequestMapping("index")
	@Transactional
	String home(ModelMap model, HttpSession httpSession) {
		httpSession.removeAttribute("titleService");
		httpSession.removeAttribute("servicesBooked");
		httpSession.removeAttribute("jsonServicesBooked");
		httpSession.removeAttribute("verifyNumber");
		model.addAttribute("layout", "home.jsp");
		return "";
	}
	
	@RequestMapping(value = "verify-form", method = RequestMethod.POST)
	String verifyEmail(ModelMap model, HttpServletRequest request, HttpSession httpSession) {
		String email = request.getParameter("inputEmail");
		String nameCustomer = request.getParameter("inputName");
		String inputPhone = request.getParameter("inputPhone");
		String inputPasswordNew = request.getParameter("inputPasswordNew");
		String verifyNumber = Helper.generateRandomSixNumber();
		String bodyVerifyMessage = Constants.TEXT_VERIFY.replace("{verifyNumber}", verifyNumber);
		Helper.sendMail(mailer, email, Constants.SUBJECT_VERIFY, bodyVerifyMessage);
		model.addAttribute("email", email);
		model.addAttribute("nameCustomer", nameCustomer);
		model.addAttribute("inputPhone", inputPhone);
		model.addAttribute("inputPasswordNew", inputPasswordNew);
		httpSession.setAttribute("verifyNumber", verifyNumber);
		model.addAttribute("layout", "verify-form.jsp");
		return "";
	}
	
	@RequestMapping("category-service")
	@Transactional
	String categoryService(ModelMap model) {
		
		model.addAttribute("layout", "category-service.jsp");
		return "";
	}
	
	@RequestMapping("discover")
	@Transactional
	String discover(ModelMap model) {
		
		model.addAttribute("layout", "discover.jsp");
		return "";
	}
	
}
