package fr.kaf.dao.implement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.kaf.bean.StatAccount;
import fr.kaf.dao.DAO;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;

public class StatAccountDAO extends DAO<StatAccount> {

	public StatAccountDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(StatAccount obj) throws SQLException {
		throw new SQLException("Impossible de créer une stats");
	}

	@Override
	public boolean delete(StatAccount obj) throws SQLException {
		throw new SQLException("Impossible de supprimer une stats");
	}

	@Override
	public boolean update(StatAccount obj) throws SQLException {
		throw new SQLException("Impossible de mettre à jour une stats");
	}

	@Override
	public SimpleObjectProperty<StatAccount> find(StatAccount obj) throws SQLException {
		throw new SQLException("Impossible de chercher simplement une stats");
	}

	// TODO Simplifier la méthode !
	@Override
	public SimpleListProperty<StatAccount> findAll() throws SQLException {
		SimpleListProperty<StatAccount> stats = new SimpleListProperty<StatAccount>();
		/** Première étape chopper la liste de tous les mois présents en bd**/
		PreparedStatement retrieveAllMonth = this.connect.prepareStatement("SELECT DISTINCT(MONTH(`date`)) FROM achat UNION SELECT DISTINCT(MONTH(`date`)) FROM commande UNION SELECT DISTINCT(MONTH(`date`)) FROM `factures`;");
		TreeSet<Integer> months = new TreeSet<>();
		ResultSet results = retrieveAllMonth.executeQuery();
		while(results.next())
			months.add(results.getInt(1));
		ArrayList<StatAccount> statsBrut = new ArrayList<StatAccount>();
		/** 2) Foutre le tout dans un set et rechercher dans toutes les tables les stats voulues **/
		for(int period : months){
			StatAccount stat = new StatAccount();
			stat.setPeriod(period);
			PreparedStatement retrieveMoneyAndCount = this.connect.prepareStatement("SELECT COUNT(identifiant),SUM(prix_negociee) FROM commande WHERE MONTH(`date`) = ?");
			retrieveMoneyAndCount.setInt(1, period);
			results = retrieveMoneyAndCount.executeQuery();
			results.first();
			stat.setNbOrd(results.getInt(1));
			stat.setTotalOrd(results.getInt(2));
			
			retrieveMoneyAndCount = this.connect.prepareStatement("SELECT COUNT(identifiant), SUM(montant) FROM factures  WHERE MONTH(`date`) = ?");
			retrieveMoneyAndCount.setInt(1, period);
			results = retrieveMoneyAndCount.executeQuery();
			results.first();
			stat.setNbBill(results.getInt(1));
			stat.setTotalBill(results.getInt(2));
			
			retrieveMoneyAndCount = this.connect.prepareStatement("SELECT SUM(prix_unitaire) FROM chaussure WHERE (identifiant_achatfrn IN (SELECT identifiant FROM `commande` WHERE MONTH(`date`)=?))");
			retrieveMoneyAndCount.setInt(1, period);
			results = retrieveMoneyAndCount.executeQuery();
			results.first();
			stat.setTotalBlk(results.getFloat(1));
			
			retrieveMoneyAndCount = this.connect.prepareStatement("SELECT COUNT(identifiant) FROM `commande` WHERE MONTH(`date`)=?");
			retrieveMoneyAndCount.setInt(1, period);
			results = retrieveMoneyAndCount.executeQuery();
			results.first();
			stat.setNbBlk(results.getInt(1));
			
			statsBrut.add(stat);
		}
		return new SimpleListProperty<StatAccount>(FXCollections.observableArrayList(statsBrut));
	}

}
