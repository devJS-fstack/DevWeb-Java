package main.implementation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.*;
import main.entity.Book;
import main.util.Constants;
public class BookRepository implements BaseRepository<Book> {
	private static BookRepository instance;
	public static BookRepository getInstance() {
		if (BookRepository.instance == null) {
			BookRepository.instance = new BookRepository();
		}
		
		return BookRepository.instance;
	}
	
	public List<Book> find(String options, Session session) {
		String hql = "FROM Book " + options;
		Query query = session.createQuery(hql);
		List<Book> list = query.list();
		
		return list;
	}
	
	public Book findOne(String options, Session session) {
		String hql = "FROM Book " + options;
		Query query = session.createQuery(hql);
		query.setMaxResults(1);
		List<Book> list = query.list();
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;	
	}
	
	public Book findBookNew(String phone, Session session) {
		String hql = "FROM Book where phoneCustomer=? and statusBook=?";;
		Query query = session.createQuery(hql).setParameter(0, phone).setParameter(1, Constants.BOOKED);
		query.setMaxResults(1);
		List<Book> list = query.list();
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;	
	}
	
	public Book findByPhoneAndStatus(String phone, String status, Session session) {
		String hql = "FROM Book WHERE phoneCustomer =? AND statusBook =?";
		Query query = session.createQuery(hql).setParameter(0, phone).setParameter(1, status);
		query.setMaxResults(1);
		List<Book> list = query.list();
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;	
	}
	
	public int deleteByField(Date dateBook, String idShift, String idStaff, Session session) {
		String hql = "DELETE FROM Book WHERE "
				+ "dateBook=? AND idShiftBook=? AND idStaff=?";
		
		Query query = session.createQuery(hql)
							 .setParameter(0, dateBook)
							 .setParameter(1, idShift)
							 .setParameter(2, idStaff);
		
		int matchedRemove = query.executeUpdate();
		System.out.println("Matched remove: " + matchedRemove);
		
		return matchedRemove;
	}
	
	public Boolean save(Book book, Session session) {
		Transaction transaction = session.beginTransaction();
		try {
			session.save(book);
			transaction.commit();
			return true;
		} catch(Exception e) {
			transaction.rollback();
			System.out.println("Error while saving Book: " + e);
		}
		
		return false;
	}
}
