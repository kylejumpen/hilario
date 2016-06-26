package fr.kaf.dao.implement;

import java.sql.Connection;

import fr.kaf.bean.Place;
import fr.kaf.dao.*;

public class PlaceDAO extends DAO<Place> {

	public PlaceDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
