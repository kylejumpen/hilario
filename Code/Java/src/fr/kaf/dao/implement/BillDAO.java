package fr.kaf.dao.implement;

import java.sql.Connection;

import fr.kaf.bean.Bill;
import fr.kaf.dao.DAO;

public class BillDAO extends DAO<Bill>{

	public BillDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Bill obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Bill obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Bill obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
