package fr.kaf.dao.implement;

import java.sql.*;
import java.util.*;

import fr.kaf.bean.Person;
import fr.kaf.dao.*;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class PersonDAO extends DAO<Person>{

	public PersonDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Person mate) throws SQLException {
		PreparedStatement createQuery = this.connect.prepareStatement("Insert into personne(nom,prenom,mot_passe,type) values(?,?,?,true);");
		createQuery.setString(1, mate.getFirstName());
		createQuery.setString(2, mate.getLastName());
		createQuery.setString(3, mate.getPassword());
		return createQuery.execute();
	}

	@Override
	public boolean delete(Person mate) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement deleteQuery = this.connect.prepareStatement("Delete from personne where identifiant = ?;");
		deleteQuery.setString(1, String.valueOf(mate.getId()));
		deleteQuery.toString();
		return deleteQuery.execute();
	}

	@Override
	public boolean update(Person mate) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public SimpleListProperty<Person> findAll() throws SQLException{
		Statement query = this.connect.createStatement();
		ResultSet results = query.executeQuery("Select identifiant,nom,prenom,mot_passe from personne where type=true;");
		ArrayList<Person> people = new ArrayList<Person>();
		while(results.next()){
			people.add(new Person(results.getInt(1),results.getString(2),results.getString(3),results.getString(4)));
		}
		
		SimpleListProperty<Person> list = new SimpleListProperty<Person>(FXCollections.observableArrayList(people)) ;
		return list;
	}
	
}

