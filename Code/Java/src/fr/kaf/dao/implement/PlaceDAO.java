package fr.kaf.dao.implement;

import java.sql.*;
import java.util.ArrayList;

import fr.kaf.bean.Place;
import fr.kaf.dao.*;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class PlaceDAO extends DAO<Place> {

	public PlaceDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Place place) throws SQLException {
		PreparedStatement createQuery = this.connect.prepareStatement("INSERT into local(nom,defaut) values(?,?);");
		createQuery.setString(1, place.getName());
		createQuery.setBoolean(2, place.getBoutique());
		return createQuery.execute();
	}

	@Override
	public boolean delete(Place place) throws SQLException {
		PreparedStatement deleteQuery = this.connect.prepareStatement("DELETE FROM local WHERE nom = ?;");
		deleteQuery.setString(1, place.getName());
		return deleteQuery.execute();
	}

	@Override
	public boolean update(Place place) throws SQLException {
		PreparedStatement updateQuery = this.connect.prepareStatement("UPDATE local SET defaut= ? WHERE nom= ?;");
		updateQuery.setString(2, place.getName());
		updateQuery.setBoolean(1, place.getBoutique());
		return updateQuery.execute();
	}
	
	public Place find(String name) throws SQLException{
		PreparedStatement retrieveQuery = this.connect.prepareStatement("SELECT * FROM local WHERE nom = ?;");
		 retrieveQuery.setString(1, name);
		 ResultSet result = retrieveQuery.executeQuery();
		 if(result.first())
				return new Place(result.getString(1),result.getBoolean(2));
		return null;
	}

	public SimpleListProperty<Place> findAll() throws SQLException{
		Statement query = this.connect.createStatement();
		ResultSet results = query.executeQuery("SELECT * FROM local;");
		ArrayList<Place> places = new ArrayList<Place>();
		while(results.next()){
			places.add(new Place(results.getString(1),results.getBoolean(2)));
		}
		return new SimpleListProperty<Place>(FXCollections.observableArrayList(places));
	}
}
