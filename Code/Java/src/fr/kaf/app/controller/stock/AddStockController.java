package fr.kaf.app.controller.stock;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ResourceBundle;

import fr.kaf.app.controller.DefaultController;
import fr.kaf.bean.Bulk;
import fr.kaf.bean.Person;
import fr.kaf.bean.Place;
import fr.kaf.bean.Shoe;
import fr.kaf.dao.DAO;
import fr.kaf.dao.implement.BulkDAO;
import fr.kaf.dao.implement.PlaceDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AddStockController extends DefaultController implements Initializable {
	
	@FXML
	VBox AddStock;
	
	@FXML
	ComboBox<Place> placesCbx;
	
	@FXML
	TextField providerTxt;
	
	@FXML
	TextField priceTxt;
	
	@FXML
	ToggleGroup typeStockTxt;
	
	@FXML
	TextField referenceTxt;
	
	@FXML
	TextField quantityTxt;
	
	DAO<Place> daoPlaces;
	
	DAO<Bulk> daoBulk;
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		super.initialize();
		daoPlaces =  (DAO<Place>) dFact.getPlaceDAO();
		daoBulk =  (DAO<Bulk>) dFact.getBulkDAO();
		try {
			placesCbx.setItems(daoPlaces.findAll());
			placesCbx.setCellFactory(new Callback<ListView<Place>, ListCell<Place>>() {
				 @Override
				 public ListCell<Place> call(ListView<Place> param) {
				  
				  return new ListCell<Place>(){
				   @Override
				   public void updateItem(Place item, boolean empty){
				    super.updateItem(item, empty);
				    if(!empty) {
				     setText(item.getName());
				    }
				   }
				  };
				 }
				});
		} catch (SQLException e) {
			// TODO Popup erreur SQL
			e.printStackTrace();
		}	
	}
	
	public void addAction(ActionEvent e) throws IOException{
		Bulk temp = new Bulk();
		temp.setBuyer(new Person());
		temp.setProvider(new Person());
		temp.setSampleShoe(new Shoe(referenceTxt.getText(), Float.parseFloat(priceTxt.getText()), placesCbx.getSelectionModel().getSelectedItem()));
		temp.getResumeInfo().getValue().put(referenceTxt.getText(), Integer.parseInt(quantityTxt.getText()));
		temp.setDate(new Date(new java.util.Date().getTime()));
		try {
			daoBulk.create(temp);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("finito");
	}
	
	public void goStockAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) AddStock.getScene().getWindow(),"/fr/kaf/app/fxml/stock/Stock.fxml");	
	}

}
