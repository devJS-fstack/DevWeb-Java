package main.implementation;

import java.util.List;

import org.hibernate.*;
import main.entity.Service;
public class ServiceRepository implements BaseRepository<Service> {
	private static ServiceRepository instance;
	public static ServiceRepository getInstance() {
		if (ServiceRepository.instance == null) {
			ServiceRepository.instance = new ServiceRepository();
		}
		
		return ServiceRepository.instance;
	}
	
	public List<Service> find(String options, Session session) {
		String hql = "FROM Service " + options;
		Query query = session.createQuery(hql);
		List<Service> list = query.list();
		
		return list;
	}
}
