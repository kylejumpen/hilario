package fr.kaf.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import fr.kaf.bean.Bill;
import fr.kaf.dao.DAO;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

public class BillDAO extends DAO<Bill>{

	public BillDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Bill invoice) throws SQLException {
		PreparedStatement createQuery = this.connect.prepareStatement("INSERT into factures(date,detail,status,identifiant_prop,montant) values(?,?,?,?,?);");
			createQuery.setDate(1,(Date) invoice.getDate());
			createQuery.setString(2, invoice.getDetail());
			createQuery.setBoolean(3, invoice.getPaid());
			createQuery.setInt(4, invoice.getBiller().getId());
			createQuery.setLong(5, invoice.getAmout());
			return createQuery.execute();
	}

	@Override
	public boolean delete(Bill invoice) throws SQLException {
		PreparedStatement deleteQuery = this.connect.prepareStatement("DELETE FROM factures WHERE identifiant= ?;");
		deleteQuery.setInt(1, invoice.getId());
		return deleteQuery.execute();
	}

	@Override
	public boolean update(Bill invoice) throws SQLException {
		PreparedStatement updateQuery = this.connect.prepareStatement("UPDATE factures SET date= ?, detail =?,status=?,identifiant_prop=?,montant=? WHERE identifiant= ?;");
			updateQuery.setDate(1,(Date) invoice.getDate());
			updateQuery.setString(2, invoice.getDetail());
			updateQuery.setBoolean(3, invoice.getPaid());
			updateQuery.setInt(4, invoice.getBiller().getId());
			updateQuery.setLong(5, invoice.getAmout());
			updateQuery.setInt(6, invoice.getId());
		return updateQuery.execute();
	}
	
	public SimpleObjectProperty<Bill> find(int idbill) throws SQLException {
		PreparedStatement retrieveQuery = this.connect.prepareStatement("SELECT * from factures WHERE identifiant = ?;");
		retrieveQuery.setInt(1, idbill);
		ResultSet result = retrieveQuery.executeQuery();
		PersonDAO personDAO = new PersonDAO(this.connect);
		if(result.first()) 
			return new SimpleObjectProperty<Bill>(new Bill(result.getInt(1),result.getDate(2),result.getString(3),result.getBoolean(4),result.getLong(6),personDAO.find(result.getInt(5)).get())); 
		return null;
	}
	
	public SimpleListProperty<Bill> findAll() throws SQLException {
		PreparedStatement retrieveQuery = this.connect.prepareStatement("SELECT * from factures;");
		ResultSet result = retrieveQuery.executeQuery();
		ArrayList<Bill> bills = new ArrayList<Bill>();
		PersonDAO personDAO = new PersonDAO(this.connect);
		while(result.next()) // Requete a travailler en fonction du choix
			bills.add(new Bill(result.getInt(1),result.getDate(2),result.getString(3),result.getBoolean(4),result.getLong(6),personDAO.find(result.getInt(5)).get())); 
		return new SimpleListProperty<Bill>(FXCollections.observableArrayList(bills));
		
	}
}


