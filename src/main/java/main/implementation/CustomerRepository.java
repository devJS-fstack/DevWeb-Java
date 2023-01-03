package main.implementation;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.entity.Customer;
import main.entity.TaiKhoan;

public class CustomerRepository {
	private static CustomerRepository instance;
	public static CustomerRepository getInstance() {
		if (CustomerRepository.instance == null) {
			CustomerRepository.instance = new CustomerRepository();
		}
		
		return CustomerRepository.instance;
	}
	
	public List<Customer> find(String options, Session session) {
		String hql = "FROM Customer " + options;
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		
		return list;
	}
	
	public Customer findByEmail(String email, Session session) {
		String hql = "FROM Customer WHERE emailCustomer=?";
		Query query = session.createQuery(hql).setParameter(0, email);
		List<Customer> list = query.list();
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}
	
	public Customer findByPhone(String phone, Session session) {
		String hql = "FROM Customer WHERE phoneCustomer=?";
		Query query = session.createQuery(hql).setParameter(0, phone);
		List<Customer> list = query.list();
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}
	
	public Boolean save(Customer customer, Session session) {
		Transaction transaction = session.beginTransaction();
		try {
			session.save(customer);
			transaction.commit();
			return true;
		} catch(Exception e) {
			transaction.rollback();
			System.out.println("Error while saving Customer: " + e);
		}
		
		return false;
	}
}
