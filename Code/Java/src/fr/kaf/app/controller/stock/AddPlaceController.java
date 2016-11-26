package fr.kaf.app.controller.stock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import fr.kaf.dao.*;

import java.io.IOException;
import java.sql.SQLException;

import fr.kaf.app.controller.DefaultController;
import fr.kaf.bean.Place;

public class AddPlaceController extends DefaultController{

	@FXML
	VBox AddPlace;
	
	@FXML
	TextArea namePlace;
	
	@FXML
	CheckBox defaultCheck;
	
	@FXML
	Label feedBackLbl;
	
	DAO<Place> dao;
	
	public void initialize(){
		super.initialize();
		dao = (DAO<Place>) dFact.getPlaceDAO();
	}
	
	public void savePlaceAction(ActionEvent e){
		feedBackLbl.setText("Opération en cours, ne pas quitter");
		feedBackLbl.setTextFill(Color.RED);
		Place temp = new Place();
		temp.setBoutique(defaultCheck.isSelected());
		temp.setName(namePlace.getText());
		try {
			if(dao.find(temp) != null){
				feedBackLbl.setText("L'emplacement existe déjà");
				return;
			}
			if(!dao.create(temp))
				feedBackLbl.setText("L'emplacement n'a pu être ajouté");
			else{
				feedBackLbl.setTextFill(Color.GREEN);
				feedBackLbl.setText("Emplacement ajouté");
			}
			
		} catch (SQLException ex) {
			feedBackLbl.setText("Erreur de connexion à la base");
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public void goStockAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) AddPlace.getScene().getWindow(),"/fr/kaf/app/fxml/stock/Stock.fxml");	
	}
	
}
