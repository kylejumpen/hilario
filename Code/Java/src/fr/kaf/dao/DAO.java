package fr.kaf.dao;

import java.sql.*;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;

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
	 * @throws SQLException 
	 */
	 public abstract boolean update(T obj) throws SQLException;
	 
	 /**
	 * Update Method
	 * @param obj
	 * @return boolean
	 * @throws SQLException 
	 */
	 public abstract SimpleObjectProperty<T> find(T obj) throws SQLException;
	 
	 /**
	 * Update Method
	 * @param obj
	 * @return boolean
	 * @throws SQLException 
	 */
	 public abstract SimpleListProperty<T> findAll() throws SQLException;
}
