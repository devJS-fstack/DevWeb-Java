package main.implementation;

import java.util.List;

import org.hibernate.*;
import main.entity.TypeService;
public class TypeServiceRepository implements BaseRepository<TypeService> {
	private static TypeServiceRepository instance;
	public static TypeServiceRepository getInstance() {
		if (TypeServiceRepository.instance == null) {
			TypeServiceRepository.instance = new TypeServiceRepository();
		}
		
		return TypeServiceRepository.instance;
	}
	
	public List<TypeService> find(String options, Session session) {
		String hql = "FROM TypeService " + options;
		Query query = session.createQuery(hql);
		List<TypeService> list = query.list();
		
		return list;
	}
}
