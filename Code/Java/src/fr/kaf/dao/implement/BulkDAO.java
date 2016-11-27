package fr.kaf.dao.implement;

import java.sql.*;
import java.util.ArrayList;

import fr.kaf.bean.Bulk;
import fr.kaf.bean.Shoe;
import fr.kaf.dao.DAO;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;

public class BulkDAO extends DAO<Bulk> {

	public BulkDAO(Connection conn) {
		super(conn);
		}

	@Override
	public boolean create(Bulk cmdbulk) throws SQLException {
		PreparedStatement createQuery = this.connect.prepareStatement("INSERT INTO achat(date,identifiant_prop,identifiant_fournisseur) VALUES(?,?,?);");
		createQuery.setDate(1, (Date) cmdbulk.getDate());
		createQuery.setInt(2, cmdbulk.getBuyer().getId());
		createQuery.setInt(3, cmdbulk.getProvider().getId());
		createQuery.execute();
		PreparedStatement retrieveIdQuery = this.connect.prepareStatement("SELECT identifiant FROM achat ORDER BY identifiant DESC LIMIT 1;");
		ResultSet result = retrieveIdQuery.executeQuery();
		result.first();
		int id = result.getInt(1);
		for(Shoe shoe : cmdbulk.getShoes()) {
			shoe.getBulk().setId(id);
			PreparedStatement createShoeQuery = this.connect.prepareStatement("INSERT into chaussure(reference,prix_unitaire,nom_local,identifiant_achatfrn) values(?,?,?,?);");
			createShoeQuery.setString(1, shoe.getReference());
			createShoeQuery.setFloat(2, shoe.getPrice());
			createShoeQuery.setString(3, shoe.getPlace().getName());
			createShoeQuery.setInt(4, shoe.getBulk().getId());
			createShoeQuery.execute();
		}
		return true;
	}

	@Override
	public boolean delete(Bulk cmdbulk) throws SQLException {
		PreparedStatement deleteQuery = this.connect.prepareStatement("DELETE from chaussure WHERE identifiant_achatfrn= ?;");
		deleteQuery.setInt(1, cmdbulk.getId());
		if(!deleteQuery.execute())
			return false;
		deleteQuery = this.connect.prepareStatement("DELETE from achat WHERE identifiant= ?;");
		deleteQuery.setInt(1, cmdbulk.getId());
		
		return deleteQuery.execute();
	}

	@Override
	public boolean update(Bulk cmdbulk) throws SQLException {
		PreparedStatement updateQuery = this.connect.prepareStatement("UPDATE achat SET identifiant_prop= ?, identifiant_fournisseur=? WHERE identifiant= ?;");
		updateQuery.setInt(1, cmdbulk.getBuyer().getId());
		updateQuery.setInt(2, cmdbulk.getProvider().getId());
		updateQuery.setInt(3, cmdbulk.getId());
		return updateQuery.execute();
	}
	
	public SimpleObjectProperty<Bulk> find (Bulk bulk) throws SQLException {
		PreparedStatement retrieveQuery = this.connect.prepareStatement("SELECT * from achat WHERE identifiant= ?;");
		retrieveQuery.setInt(1, bulk.getId());
		ResultSet result = retrieveQuery.executeQuery();
		if(result.first())
			return new SimpleObjectProperty<Bulk>(new Bulk(bulk.getId(),result.getDate(2),result.getInt(3),result.getInt(4)));
		else return null;
	}

	@Override
	public SimpleListProperty<Bulk> findAll() throws SQLException {
		PreparedStatement retrieveQuery = this.connect.prepareStatement("SELECT * from achat;");
		ResultSet results = retrieveQuery.executeQuery();
		ArrayList<Bulk> bulks = new ArrayList<>(); 
		while(results.next())
			bulks.add(new Bulk(results.getInt(1),results.getDate(2),results.getInt(3),results.getInt(4)));
		return new SimpleListProperty<Bulk>(FXCollections.observableArrayList(bulks));
	}
	

}
