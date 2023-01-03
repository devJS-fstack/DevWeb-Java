package main.implementation;

import java.util.List;
import org.hibernate.Session;

public interface BaseRepository<E> {
	public List<E> find(String query, Session session);
}
