package dao;

import java.util.List;

public interface DAOInterface<T> {
	
	public void insert(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public List<T> selectAll();
	
	public List<T> selectByName(T t);
	
	public List<T> selectByCondition(String condition);
}
