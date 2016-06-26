package fr.kaf.dao;

import java.sql.*;

public abstract class DAO<T> {
	protected Connection connect = null;
	
	public DAO(Connection conn){
	    this.connect = conn;
	}
	
	 /**
	 * Creation Method
	 * @param obj
	 * @return boolean 
	 */
	 public abstract boolean create(T obj);

	 /**
	 * Delete Method
	 * @param obj
	 * @return boolean 
	 */
	 public abstract boolean delete(T obj);

	 /**
	 * Update Method
	 * @param obj
	 * @return boolean
	 */
	 public abstract boolean update(T obj);
	 
}
