package main.implementation;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import main.entity.Staff;

public class StaffRepository {
	private static StaffRepository instance;
	public static StaffRepository getInstance() {
		if (StaffRepository.instance == null) {
			StaffRepository.instance = new StaffRepository();
		}
		
		return StaffRepository.instance;
	}
	
	public List<Staff> find(String options, Session session) {
		String hql = "FROM Staff " + options;
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		
		return list;
	}
	
	public List<Staff> findStaffByDateRegis(Date dateRegis, String idStore, Session session) {
		String hql = "FROM Staff s JOIN s.listRegis rs WHERE rs.dateRegis = ?"
				+ " AND s.store.idStore = ?";
		Query query = session.createQuery(hql)
											  .setParameter(0, dateRegis)
											  .setParameter(1, idStore);
		List<Staff> list = query.list();
		return list;
	}
	
	public Staff findById(String idStaff, Session session) {
		String hql = "FROM Staff WHERE idStaff=?";
		Query query = session.createQuery(hql).setParameter(0, idStaff);
		query.setMaxResults(1);
		
		List<Staff> staffs = query.list();
		
		if (staffs.size() > 0) {
			return staffs.get(0);
		}
		
		return null;
	}
}
