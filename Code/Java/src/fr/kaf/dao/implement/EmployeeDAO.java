package fr.kaf.dao.implement;

import java.sql.Connection;

import fr.kaf.bean.Employee;
import fr.kaf.dao.DAO;

public class EmployeeDAO extends DAO<Employee> {

	public EmployeeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Employee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Employee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Employee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
