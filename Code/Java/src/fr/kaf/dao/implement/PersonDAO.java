package fr.kaf.dao.implement;

import java.sql.Connection;

import fr.kaf.bean.Person;
import fr.kaf.dao.*;

public class PersonDAO extends DAO<Person>{

	public PersonDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

}

