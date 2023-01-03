package main.implementation;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import main.entity.TaiKhoan;
import main.util.Constants;

public class AccountRepository {
	private static AccountRepository instance;
	public static AccountRepository getInstance() {
		if (AccountRepository.instance == null) {
			AccountRepository.instance = new AccountRepository();
		}
		
		return AccountRepository.instance;
	}
	
	public List<TaiKhoan> find(String options, Session session) {
		String hql = "FROM TaiKhoan " + options;
		Query query = session.createQuery(hql);
		List<TaiKhoan> list = query.list();
		
		return list;
	}
	
	public TaiKhoan findById(String account, Session session) {
		String hql = "FROM TaiKhoan WHERE account=?";
		Query query = session.createQuery(hql).setParameter(0, account);
		List<TaiKhoan> list = query.list();
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}
	
	public TaiKhoan findByIdAndActive(String account, Session session) {
		String hql = "FROM TaiKhoan WHERE account=? AND status=?";
		Query query = session.createQuery(hql).setParameter(0, account).setParameter(1, Constants.STATUS_ACTIVE_ACCOUNT);
		List<TaiKhoan> list = query.list();
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}
	
	public Boolean save(TaiKhoan tk, Session session) {
		Transaction transaction = session.beginTransaction();
		try {
			session.save(tk);
			transaction.commit();
			return true;
		} catch(Exception e) {
			transaction.rollback();
			System.out.println("Error while saving TaiKhoan: " + e);
		}
		
		return false;
	}
	
	public Boolean update(TaiKhoan tk, Session session) {
		Transaction transaction = session.beginTransaction();
		try {
			session.update(tk);
			transaction.commit();
			return true;
		} catch(Exception e) {
			transaction.rollback();
			System.out.println("Error while saving TaiKhoan: " + e);
		}
		
		return false;
	}
}
