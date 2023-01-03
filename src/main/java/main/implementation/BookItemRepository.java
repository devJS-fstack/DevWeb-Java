package main.implementation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.*;

import main.entity.Book;
import main.entity.BookItem;
public class BookItemRepository implements BaseRepository<BookItem> {
	private static BookItemRepository instance;
	public static BookItemRepository getInstance() {
		if (BookItemRepository.instance == null) {
			BookItemRepository.instance = new BookItemRepository();
		}
		
		return BookItemRepository.instance;
	}
	
	public List<BookItem> find(String options, Session session) {
		String hql = "FROM BookItem " + options;
		Query query = session.createQuery(hql);
		List<BookItem> list = query.list();
		
		return list;
	}
	
	public BookItem findOne(String options, Session session) {
		String hql = "FROM BookItem " + options;
		Query query = session.createQuery(hql);
		query.setMaxResults(1);
		List<BookItem> list = query.list();
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;	
	}
	
	public int deleteByField(Date dateBook, String idShift, String idStaff, Session session) {
		String hql = "DELETE FROM BookItem WHERE "
				+ "dateBook=? AND idShiftBook=? AND idStaff=?";
		
		Query query = session.createQuery(hql)
							 .setParameter(0, dateBook)
							 .setParameter(1, idShift)
							 .setParameter(2, idStaff);
		
		int matchedRemove = query.executeUpdate();
		System.out.println("Matched remove: " + matchedRemove);
		
		return matchedRemove;
	}
	
	public Boolean save(BookItem bookItem, Session session) {
		Transaction transaction = session.beginTransaction();
		try {
			session.save(bookItem);
			transaction.commit();
			return true;
		} catch(Exception e) {
			transaction.rollback();
			System.out.println("Error while saving Book: " + e);
		}
		
		return false;
	}
	
	public Boolean insertMany(List<BookItem> listBookItem, Session session) {
		int count = 0;
		for (;count < listBookItem.size(); count++) {
			this.save(listBookItem.get(count), session);
		}
		
		return count == listBookItem.size();
	}
}
