//package poly.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.transaction.Transactional;
//
//import org.hibernate.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import ptit.entity.Users;
//
//@Controller
//@RequestMapping("/user")
//public class HomeController {
//	@Autowired
//	SessionFactory factory;
//	
//	@Transactional
//	@RequestMapping("index")
//	public String index(ModelMap model) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM Users";
//		Query query = session.createQuery(hql);
//		
//		List<Users> list = query.list();
//		model.addAttribute("users", list);
//		return "user/index";
//	}
//	
//	@RequestMapping("insert")
//	public String formInsert(@ModelAttribute("user")Users user) {
//		return "user/insert";
//	}
//	
//
//	@RequestMapping(value="insert", method = RequestMethod.POST)
//	public String insertUser(@ModelAttribute("user")Users user, ModelMap model) {
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		try {
//			session.save(user);
//			transaction.commit();
//			model.addAttribute("msg", "Thêm user thành công !");
//		} catch (Exception err) {
//			transaction.rollback();
//			model.addAttribute("msg", "Thêm user thất bại !");
//			System.out.print("Error while inserting user: " + err);
//		} finally {
//			session.close();
//		}
//		return "user/insert";
//	}
//	
//	@RequestMapping(value="update/{slug}", method = RequestMethod.GET)
//	public String formUpdate(@ModelAttribute("user")Users user, @PathVariable("slug") String username) {
//		user.setUsername(username);
//		return "user/update";
//	}
//	
//	@RequestMapping(value="update/{slug}", method = RequestMethod.POST)
//	public void updateUser(@ModelAttribute("user")Users user, ModelMap model, @PathVariable("slug") String username, 
//			HttpServletResponse httpServletResponse) {
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		user.setUsername(username);
//		try {
//			session.update(user);
//			transaction.commit();
//			model.addAttribute("msg", "Update user thành công !");
//		} catch (Exception err) {
//			transaction.rollback();
//			model.addAttribute("msg", "Update user thất bại !");
//			System.out.print("Error while inserting user: " + err);
//		} finally {
//			session.close();
//		}
//		
//		httpServletResponse.setHeader("Location", "http://localhost:3000/Lab5/user/index.htm");
//	    httpServletResponse.setStatus(302);
//	}
//	
//	@RequestMapping(value="delete/{slug}", method = RequestMethod.GET)
//	public void deleteUser(@ModelAttribute("user")Users user, ModelMap model, @PathVariable("slug") String username, 
//			HttpServletResponse httpServletResponse) {
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		user.setUsername(username);
//		try {
//			session.delete(user);
//			transaction.commit();
//		} catch (Exception err) {
//			transaction.rollback();
//			System.out.print("Error while inserting user: " + err);
//		} finally {
//			session.close();
//		}
//		
//		httpServletResponse.setHeader("Location", "http://localhost:3000/Lab5/user/index.htm");
//	    httpServletResponse.setStatus(302);
//	}
//	
//}
