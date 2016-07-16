package fr.kaf.dao.implement;

import java.sql.*;
import java.util.*;

import fr.kaf.bean.Person;
import fr.kaf.dao.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

public class PersonDAO extends DAO<Person>{

	public PersonDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Person mate) throws SQLException {
		PreparedStatement createQuery = this.connect.prepareStatement("INSERT into personne(nom,prenom,mot_passe,type) values(?,?,?,true);");
		createQuery.setString(1, mate.getFirstName());
		createQuery.setString(2, mate.getLastName());
		createQuery.setString(3, mate.getPassword());
		return createQuery.execute();
	}

	@Override
	public boolean delete(Person mate) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement deleteQuery = this.connect.prepareStatement("DELETE FROM personne WHERE identifiant = ?;");
		deleteQuery.setInt(1, mate.getId());
		deleteQuery.toString();
		return deleteQuery.execute();
	}

	@Override
	public boolean update(Person mate) throws SQLException {
		PreparedStatement updateQuery = this.connect.prepareStatement("UPDATE personne SET nom= ?, prenom = ?, mot_passe=? WHERE identifiant= ?;");
		updateQuery.setString(1, mate.getFirstName());
		updateQuery.setString(2, mate.getLastName());
		updateQuery.setString(3, mate.getPassword());
		updateQuery.setInt(4,mate.getId());
		return updateQuery.execute();
	}
	
	public SimpleObjectProperty<Person> find(int id) throws SQLException{
		PreparedStatement retrieveQuery = this.connect.prepareStatement("SELECT nom,prenom,mot_passe FROM personne WHERE identifiant= ?;");
		retrieveQuery.setInt(1, id);
		ResultSet result = retrieveQuery.executeQuery();
		if(result.first())
			return new SimpleObjectProperty<Person>(new Person(id,result.getString(1),result.getString(2),result.getString(3)));
		return null;
	}
	
	public SimpleListProperty<Person> findAll() throws SQLException{
		Statement query = this.connect.createStatement();
		ResultSet results = query.executeQuery("SELECT identifiant,nom,prenom,mot_passe FROM personne WHERE type=true;");
		ArrayList<Person> people = new ArrayList<Person>();
		while(results.next())
			people.add(new Person(results.getInt(1),results.getString(2),results.getString(3),results.getString(4)));
		
		return new SimpleListProperty<Person>(FXCollections.observableArrayList(people));
	}
	
}

