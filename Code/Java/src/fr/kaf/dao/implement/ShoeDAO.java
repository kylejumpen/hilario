package fr.kaf.dao.implement;

import java.sql.*;
import fr.kaf.bean.Shoe;
import fr.kaf.dao.DAO;

public class ShoeDAO extends DAO<Shoe>{

	public ShoeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Shoe shoe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Shoe shoe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Shoe shoe) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
