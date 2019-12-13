package nuovoConcessionario.dao;

import java.util.Collection;

import nuovoConcessionario.db.ConcessionarioException;

public interface Dao<T> {
	
	T create(T t) throws ConcessionarioException;
	
	Collection<T> findAll() throws ConcessionarioException;
	
	T findById(Long id) throws ConcessionarioException;
	
	int remove(Long id) throws ConcessionarioException;
	
	int remove(T t) throws ConcessionarioException;
	
	int update(T t) throws ConcessionarioException;
	
}
