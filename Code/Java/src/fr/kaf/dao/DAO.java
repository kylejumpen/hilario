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
	 * @throws SQLException 
	 */
	 public abstract boolean create(T obj) throws SQLException;

	 /**
	 * Delete Method
	 * @param obj
	 * @return boolean 
	 * @throws SQLException 
	 */
	 public abstract boolean delete(T obj) throws SQLException;

	 /**
	 * Update Method
	 * @param obj
	 * @return boolean
	 */
	 public abstract boolean update(T obj);
	 
}
