//package poly.controller;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.transaction.Transactional;
//
//import org.hibernate.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//
//import ptit.entity.Records;
//import ptit.entity.Staffs;
//import ptit.entity.Users;
//
//@Controller
//public class StaffController {
//	@Autowired
//	SessionFactory factory;
//	
//	@Transactional
//	@RequestMapping("/staff/index")
//	public String index(ModelMap model) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM Staffs";
//		Query query = session.createQuery(hql);
//		
//		List <Staffs> staffs = query.list();
//		model.addAttribute("staffs", staffs);
//		
//		return "staff/index";
//	}
//	
//	@Transactional
//	@RequestMapping("/staff/report")
//	public String report(ModelMap model) {
//		Session session = factory.getCurrentSession();
//		String hql = "SELECT r.staff.id,"
//				+ "SUM(case when r.type = 1 then 1 else 0 end),"
//				+ "SUM(case when r.type = 0 then 1 else 0 end)"
//				+ " FROM Records r"
//				+ " GROUP BY r.staff.id";
//		Query query = session.createQuery(hql);
//		
//		List <Object[]> list= query.list();
//		model.addAttribute("arrays", list);
//		
//		return "staff/report";
//	}
//	
//	@Transactional
//	@RequestMapping(value="/record/insert", method = RequestMethod.GET)
//	public String formInsert(ModelMap model) {
//		model.addAttribute("record", new Records());
//		return "record/insert";
//	}
//	
//	@Transactional
//	@RequestMapping(value="/record/insert", method = RequestMethod.POST)
//	public String insertRecord(ModelMap model, @ModelAttribute("record") Records record) {
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		try {
//			record.setDate(new Date());
//			session.save(record);
//			transaction.commit();
//			model.addAttribute("msg", "Thêm record mới thành công");
//		} catch (Exception e) {
//			model.addAttribute("msg", "Thêm record mới thất bại");
//			transaction.rollback();
//			System.out.print("Error while insert new reocrd: " + e);
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return "record/insert";
//	}
//	
//	@Transactional
//	@ModelAttribute("staffs")
//	public List<Staffs> getStaffs() {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM Staffs";
//		
//		Query query = session.createQuery(hql);
//		List<Staffs> list = query.list();
//		return list;
//	}
//}
