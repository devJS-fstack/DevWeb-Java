package main.implementation;

import java.util.List;

import org.hibernate.*;
import main.entity.Shift;
import main.entity.Staff;
public class ShiftRepository implements BaseRepository<Shift> {
	private static ShiftRepository instance;
	public static ShiftRepository getInstance() {
		if (ShiftRepository.instance == null) {
			ShiftRepository.instance = new ShiftRepository();
		}
		
		return ShiftRepository.instance;
	}
	
	public List<Shift> find(String options, Session session) {
		String hql = "FROM Shift " + options;
		Query query = session.createQuery(hql);
		List<Shift> list = query.list();
		
		return list;
	}
	
	public Shift findById(String idShift, Session session) {
		String hql = "FROM Shift WHERE idShift=?";
		Query query = session.createQuery(hql).setParameter(0, idShift);
		query.setMaxResults(1);
		
		List<Shift> list = query.list();
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}
}
