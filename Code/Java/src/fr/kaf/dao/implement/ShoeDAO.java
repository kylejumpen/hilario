package fr.kaf.dao.implement;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import fr.kaf.bean.Place;
import fr.kaf.bean.Shoe;
import fr.kaf.dao.DAO;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

public class ShoeDAO extends DAO<Shoe>{

	public ShoeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Shoe shoe) throws SQLException {
		PreparedStatement createQuery = this.connect.prepareStatement("INSERT into chaussure(reference,prix_unitaire,nom_local,identifiant_achatfrn) values(?,?,?,?);");
		createQuery.setString(1, shoe.getReference());
		createQuery.setFloat(2, shoe.getPrice());
		createQuery.setString(3, shoe.getPlace().getName());
		createQuery.setInt(4, shoe.getBulk().getId());
		return createQuery.execute();
	}

	@Override
	public boolean delete(Shoe shoe) throws SQLException {
		PreparedStatement deleteQuery = this.connect.prepareStatement("DELETE FROM chaussure WHERE identifiant = ? ");
		deleteQuery.setInt(1, shoe.getId());
		return deleteQuery.execute();
	}

	@Override
	public boolean update(Shoe shoe) throws SQLException {
		PreparedStatement updateQuery = this.connect.prepareStatement("UPDATE chaussure SET reference=?, prix_unitaire= ?,nom_local=?,identifiant_commande=?,identifiant_achatfrn=?  WHERE identifiant = ? ");
		updateQuery.setString(1, shoe.getReference());
		updateQuery.setFloat(2, shoe.getPrice());
		updateQuery.setString(3, shoe.getPlace().getName());
		updateQuery.setInt(4, shoe.getOrder().getId());
		updateQuery.setInt(5, shoe.getBulk().getId());
		updateQuery.setInt(6, shoe.getId());
		return updateQuery.execute();
	}

	public SimpleListProperty<Shoe> findByPlace(String nomPlace) throws SQLException{
		PreparedStatement findQuery = this.connect.prepareStatement("SELECT identifiant,reference,prix_unitaire,identifiant_commande,identifiant_achatfrn FROM chaussure WHERE nom_local= ?;");
		findQuery.setString(1, nomPlace);
		ResultSet results = findQuery.executeQuery();
		ArrayList<Shoe> shoes = new ArrayList<Shoe>();
		while(results.next())
			shoes.add(new Shoe(results.getInt(1),results.getString(2),results.getFloat(3),nomPlace,results.getInt(4),results.getInt(5)));
	
		return new SimpleListProperty<Shoe>(FXCollections.observableArrayList(shoes));
	}
	
	public SimpleListProperty<Shoe> findByOrder(int idorder) throws SQLException{
		PreparedStatement findQuery = this.connect.prepareStatement("SELECT identifiant,reference,prix_unitaire,nom_local,identifiant_achatfrn FROM chaussure WHERE identifiant_commande= ?;");
		findQuery.setInt(1, idorder);
		ResultSet results = findQuery.executeQuery();
		ArrayList<Shoe> shoes = new ArrayList<Shoe>();
		while(results.next())
			shoes.add(new Shoe(results.getInt(1),results.getString(2),results.getFloat(3),results.getString(4),idorder,results.getInt(5)));
	
		return new SimpleListProperty<Shoe>(FXCollections.observableArrayList(shoes));
	}
	
	public SimpleListProperty<Shoe> findByBulk(int idbulk) throws SQLException{
		PreparedStatement findQuery = this.connect.prepareStatement("SELECT identifiant,reference,prix_unitaire,nom_local,identifiant_commande FROM chaussure WHERE identifiant_achatfrn= ?;");
		findQuery.setInt(1, idbulk);
		ResultSet results = findQuery.executeQuery();
		ArrayList<Shoe> shoes = new ArrayList<Shoe>();
		while(results.next())
			shoes.add(new Shoe(results.getInt(1),results.getString(2),results.getFloat(3),results.getString(4),results.getInt(5),idbulk));
	
		return new SimpleListProperty<Shoe>(FXCollections.observableArrayList(shoes));
	}

	//TODO Remonter la somme pour avoir une idée du totale de marchandise à écouler, moyenne du prix et ecartype pour marchandage
	public HashMap<String,Integer> findRefAndQtyByPlace(Place place) throws SQLException{
		HashMap<String,Integer> temp = new HashMap<>();
		PreparedStatement findQuery = this.connect.prepareStatement("SELECT reference,COUNT(*),AVG(prix_unitaire),STD(prix_unitaire) FROM chaussure WHERE (identifiant_commande IS NULL AND nom_local = ?)GROUP BY reference,nom_local ");
		findQuery.setString(1, place.getName());
		ResultSet results = findQuery.executeQuery();
		while(results.next())
			temp.put(results.getString(1), results.getInt(2));
		return temp;
	}
	
	@Override
	public SimpleObjectProperty<Shoe> find(Shoe obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleListProperty<Shoe> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
