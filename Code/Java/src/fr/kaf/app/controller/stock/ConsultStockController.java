package fr.kaf.app.controller.stock;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import fr.kaf.app.controller.DefaultController;
import fr.kaf.bean.Bulk;
import fr.kaf.bean.Employee;
import fr.kaf.bean.Place;
import fr.kaf.bean.Shoe;
import fr.kaf.dao.DAO;
import fr.kaf.dao.implement.ShoeDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ConsultStockController extends DefaultController implements Initializable {

	@FXML
	VBox ConsultStock;
	
	@FXML
	ComboBox<Place> placesCbx;
	
	@FXML
	TableView table;
	
	@FXML
	TableColumn<HashMap.Entry<String, Integer>, String> referenceCol;
	
	@FXML
	TableColumn<HashMap.Entry<String, Integer>, Integer> quantityCol;
	
	Map<String,Integer> inventory;
	
	DAO<Place> daoPlaces;
	
	ShoeDAO daoShoe;
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		super.initialize();
		daoPlaces =  (DAO<Place>) dFact.getPlaceDAO();
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
			referenceCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HashMap.Entry<String, Integer>, String>, ObservableValue<String>>() {

	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<HashMap.Entry<String, Integer>, String> p) {
	                return new SimpleStringProperty(p.getValue().getKey());
	            }
	        });
			
			 quantityCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HashMap.Entry<String, Integer>, Integer>, ObservableValue<Integer>>() {

	            @Override
	           public ObservableValue<Integer> call(TableColumn.CellDataFeatures<HashMap.Entry<String, Integer>, Integer> p) {
	                return new SimpleIntegerProperty(p.getValue().getValue()).asObject();
	            }
	        });
			
			placesCbx.setOnAction((event) -> fillTable(placesCbx.getSelectionModel().getSelectedItem()));

		} catch (SQLException e) {
			// TODO Popup erreur SQL
			e.printStackTrace();
		}	
	}
	
	
	public void fillTable(Place place){
		if(place == null)
			return;		
		try {
			inventory = new HashMap<>(daoShoe.findRefAndQtyByPlace(place));
			ObservableList<HashMap.Entry<String, Integer>> allData = FXCollections.observableArrayList(inventory.entrySet());
			table.setItems(allData);
		} catch (SQLException e) {
			// TODO Erreur SQL à mettre
			e.printStackTrace();
		}
		
	}
	
	
	
	public void goStockAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) ConsultStock.getScene().getWindow(),"/fr/kaf/app/fxml/stock/Stock.fxml");	
	}

}
