package fr.kaf.dao.implement;

import java.sql.Connection;
import fr.kaf.bean.Shoe;
import fr.kaf.dao.DAO;

public class ShoeDAO extends DAO<Shoe>{

	public ShoeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Shoe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Shoe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Shoe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
