package main.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.entity.Test;

@Controller
public class HomeController {

	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	@Transactional
	String index() {
		System.out.println("GOING: " + factory);
		Session session = factory.openSession();
	
		String hql = "FROM Test";
		Query query = session.createQuery(hql);
		
		List <Test> list = query.list();
		
		System.out.println("Size: " + list.size());
		
		Test test = list.get(0);
		System.out.println("name: " + test.getName());
//		System.out.println("SIZE STAFFS: " + staffs.size());
		return "index";
	}
}
