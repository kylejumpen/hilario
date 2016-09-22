package fr.kaf.dao.implement;

import java.sql.*;
import java.util.ArrayList;

import fr.kaf.bean.Employee;
import fr.kaf.dao.DAO;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;

public class EmployeeDAO extends DAO<Employee> {

	public EmployeeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Employee mate) throws SQLException {
		PreparedStatement createQuery = this.connect.prepareStatement("INSERT into personne(nom,prenom,mot_passe,type) values(?,?,?,false);");
		createQuery.setString(1, mate.getFirstName());
		createQuery.setString(2, mate.getLastName());
		createQuery.setString(3, mate.getPassword());
		createQuery.execute();
		createQuery = this.connect.prepareStatement("SELECT identifiant from personne WHERE nom= ? ORDER BY identifiant DESC LIMIT 1;");
		ResultSet idsql = createQuery.executeQuery();
		int idEmp = idsql.getInt(1);
		createQuery = this.connect.prepareStatement("INSERT into employee(identifiant,droits,salaire) values(?,?,?);");
		createQuery.setInt(1, idEmp);
		createQuery.setString(2,String.valueOf(mate.getDroit()));
		createQuery.setInt(3, mate.getSalary());
		return createQuery.execute();
	}

	@Override
	public boolean delete(Employee mate) throws SQLException {
		PreparedStatement deleteQuery = this.connect.prepareStatement("DELETE FROM employee WHERE identifiant = ?;");
		deleteQuery.setInt(1, mate.getId());
		deleteQuery.execute();
		deleteQuery = this.connect.prepareStatement("DELETE FROM personne WHERE identifiant = ?;");
		deleteQuery.setInt(1, mate.getId());
		return deleteQuery.execute();
	}

	@Override
	public boolean update(Employee mate) throws SQLException {
		PreparedStatement updateQuery = this.connect.prepareStatement("UPDATE personne SET nom= ?, prenom = ?, mot_passe=? WHERE identifiant= ?;");
		updateQuery.setString(1, mate.getFirstName());
		updateQuery.setString(2, mate.getLastName());
		updateQuery.setString(3, mate.getPassword());
		updateQuery.setInt(4,mate.getId());
		updateQuery.execute();
		updateQuery = this.connect.prepareStatement("UPDATE employee SET droits= ?, salaire = ? WHERE identifiant= ?;");
		updateQuery.setString(1, String.valueOf(mate.getDroit()));
		updateQuery.setInt(2, mate.getSalary());
		updateQuery.setInt(3,mate.getId());
		return updateQuery.execute();
	}
	
	public SimpleObjectProperty<Employee> find(Employee emp) throws SQLException{
		PreparedStatement retrieveQuery = this.connect.prepareStatement("Select identifiant,nom,prenom,mot_passe,droits,salaire from personne Natural JOIN employee WHERE identifiant= ?;");
		retrieveQuery.setInt(1, emp.getId());
		ResultSet result = retrieveQuery.executeQuery();
		if(result.first())
			return new SimpleObjectProperty<Employee>(new Employee(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5).charAt(0),result.getInt(6)));
		return null;
	}

	public SimpleListProperty<Employee> findAll() throws SQLException{
		Statement query = this.connect.createStatement();
		ResultSet results = query.executeQuery("Select identifiant,nom,prenom,mot_passe,droits,salaire from personne Natural JOIN employee;");
		ArrayList<Employee> people = new ArrayList<Employee>();
		while(results.next()){
			people.add(new Employee(results.getInt(1),results.getString(2),results.getString(3),results.getString(4),results.getString(5).charAt(0),results.getInt(6)));
		}
		return new SimpleListProperty<Employee>(FXCollections.observableArrayList(people));
	}
}
