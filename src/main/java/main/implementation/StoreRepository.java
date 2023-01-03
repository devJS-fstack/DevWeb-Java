package main.implementation;

import java.util.List;

import org.hibernate.*;
import main.entity.Store;
public class StoreRepository implements BaseRepository<Store> {
	private static StoreRepository instance;
	public static StoreRepository getInstance() {
		if (StoreRepository.instance == null) {
			StoreRepository.instance = new StoreRepository();
		}
		
		return StoreRepository.instance;
	}
	
	public List<Store> find(String options, Session session) {
		String hql = "FROM Store " + options;
		Query query = session.createQuery(hql);
		List<Store> stores = query.list();
		
		return stores;
	}
}
