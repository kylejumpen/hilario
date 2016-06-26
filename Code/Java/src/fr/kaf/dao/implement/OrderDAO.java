package fr.kaf.dao.implement;

import java.sql.Connection;

import fr.kaf.bean.Order;
import fr.kaf.dao.DAO;

public class OrderDAO extends DAO<Order> {

	public OrderDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
