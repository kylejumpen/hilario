package fr.kaf.app.controller.command;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import fr.kaf.app.controller.DefaultController;
import fr.kaf.bean.Place;
import fr.kaf.dao.DAO;
import fr.kaf.dao.implement.PlaceDAO;
import fr.kaf.dao.implement.ShoeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

//TODO Vérification des champs
public class UnitController extends DefaultController implements Initializable {

	@FXML
	VBox Unit;
	
	@FXML
	TextField quantityFld;
	
	@FXML
	TextField priceFld;
	
	@FXML
	ToggleGroup typePriceGrp;
	
	@FXML
	Button cancelButton;
	
	@FXML
	ComboBox<String> referenceCbx;
	
	@FXML
	ComboBox<Place> placesCbx;
	
	@FXML
	Label estimationLbl;
	
	@FXML
	Label nbDispLbl;
	
	PlaceDAO daoPlaces;
	
	ShoeDAO daoShoe;
	
	Map<String,Integer> inventory;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		super.initialize();
		daoPlaces = (PlaceDAO) dFact.getPlaceDAO();
		daoShoe =  (ShoeDAO) dFact.getShoeDAO();
		inventory = new HashMap<>();
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
			placesCbx.setOnAction((event) -> changeReference(placesCbx.getSelectionModel().getSelectedItem()));
			referenceCbx.setOnAction((event) -> changeNbDisp(referenceCbx.getSelectionModel().getSelectedItem()));
			priceFld.setOnKeyReleased((event) -> changeEstimatedPrice(quantityFld.getText()));
			typePriceGrp.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> changeTypeSell() );
		}catch (SQLException e) {
				// TODO Popup erreur SQL
				e.printStackTrace();
			}	
	}	

	public void goCommandAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Unit.getScene().getWindow(),"/fr/kaf/app/fxml/command/Command.fxml");	
	}
	
	public void cancelButtonAction(){
		quantityFld.setText("");
		priceFld.setText("");
		estimationLbl.setText("");
	}
	
	private void changeNbDisp(String selectedReference) {
		if(selectedReference == null){
			nbDispLbl.setText("N/A");
			return ;
		}
		nbDispLbl.setText(""+inventory.get(selectedReference));
	}

	private void changeReference(Place place) {
		if(place == null){
			referenceCbx.getItems().clear();
			referenceCbx.setDisable(true);
			return;		
		}
		try {
			referenceCbx.setDisable(false);
			inventory = new HashMap<>(daoShoe.findRefAndQtyByPlace(place));
			if(inventory.entrySet().size() == 0){
				referenceCbx.setDisable(true);
				return;
			}
			referenceCbx.getItems().clear();
			referenceCbx.getItems().setAll((String[]) inventory.keySet().toArray(new String[0]));
		} catch (SQLException e) {
			// TODO Erreur SQL à mettre
			referenceCbx.setDisable(true);
			e.printStackTrace();
		}		
	}
	
	private void changeTypeSell(){
		if(typePriceGrp.selectedToggleProperty().getValue().equals(typePriceGrp.getToggles().get(0))){
			estimationLbl.setText("" + (Integer.parseInt(quantityFld.getText()) * Double.parseDouble(priceFld.getText().replaceAll(",", "."))));
		}else{
			estimationLbl.setText("" +Double.parseDouble(priceFld.getText().replaceAll(",", ".")));
		}
	}
	
	private void changeEstimatedPrice(String quantity) {
		try{
			estimationLbl.setText("" + (Integer.parseInt(quantity) * Double.parseDouble(priceFld.getText().replaceAll(",", "."))));
		}catch(Exception e){ 
			//TODO erreur popup mauvais format
			estimationLbl.setText("Erreur de format");
			e.printStackTrace();
		}
		
	}
	
}
