package fr.kaf.dao;

import java.sql.Connection;

import fr.kaf.connection.ConnectParameter;
import fr.kaf.dao.implement.*;

public class DAOFactory {

	protected static final Connection conn = ConnectParameter.getInstance();
	
	public DAO<?> getBillDAO(){
		return new BillDAO(conn);
	}
	
	public DAO<?> getBulkDAO(){
		return new BulkDAO(conn);
	}
	
	public DAO<?> getEmployeeDAO(){
		return new EmployeeDAO(conn);
	}
	
	public DAO<?> getOrderDAO(){
		return new OrderDAO(conn);
	}
	
	public DAO<?> getPersonDAO(){
		return new PersonDAO(conn);
	}
	
	public DAO<?> getPlaceDAO(){
		return new PlaceDAO(conn);
	}
	
	public DAO<?> getShoeDAO(){
		return new ShoeDAO(conn);
	}
	
	public DAO<?> getStatAccountDAO(){
		return new StatAccountDAO(conn);
	}
}
