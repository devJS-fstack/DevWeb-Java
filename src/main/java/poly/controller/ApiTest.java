package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import main.entity.Staff;

@Controller
@RequestMapping("/dev/api")
public class ApiTest {
	
	@Autowired
	SessionFactory factory;
	
	@Transactional
	@RequestMapping("/staffs")
	@ResponseBody
	public String getStaffs(HttpServletResponse response) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		System.out.println("hi");
		List <Staff> staffs = query.list();
		
		String json = new Gson().toJson(staffs);
		
		return json;
	}
}
