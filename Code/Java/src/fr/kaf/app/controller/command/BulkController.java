package fr.kaf.app.controller.command;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import fr.kaf.app.controller.DefaultController;
import fr.kaf.bean.Employee;
import fr.kaf.bean.Order;
import fr.kaf.bean.Place;
import fr.kaf.bean.Shoe;
import fr.kaf.dao.implement.OrderDAO;
import fr.kaf.dao.implement.PlaceDAO;
import fr.kaf.dao.implement.ShoeDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class BulkController extends DefaultController implements Initializable {

	@FXML
	VBox Bulk;
	
	@FXML
	ComboBox<Place> placesCbx;
	
	@FXML
	ComboBox<String> referenceCbx;
	
	@FXML
	Label estimationLbl;
	
	@FXML
	Label estimationTotalLbl;
	
	@FXML
	Label nbDispLbl;
	
	@FXML
	TableView<Order> commandTab;
	
	@FXML
	TableColumn<Order,String> referenceCol;
	
	@FXML
	TableColumn<Order,Integer> quantityCol;
	
	@FXML
	TableColumn<Order,Integer> priceCol;
	
	@FXML
	TextField quantityFld;
	
	@FXML
	TextField priceFld;
	
	@FXML
	ToggleGroup typePriceGrp;
	
	OrderDAO daoOrder;
	
	PlaceDAO daoPlaces;
	
	ShoeDAO daoShoe;
	
	Map<String,Integer> inventory;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		super.initialize();
		daoPlaces = (PlaceDAO) dFact.getPlaceDAO();
		daoShoe =  (ShoeDAO) dFact.getShoeDAO();
		daoOrder = (OrderDAO) dFact.getOrderDAO();
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
			referenceCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSampleShoe().get().getReference()));
			quantityCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getResumeInfo().get().get(cellData.getValue().getSampleShoe().get().getReference())).asObject());
			priceCol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("realPrice"));
		}catch (SQLException e) {
			// TODO Popup erreur SQL
			showException(e);
			e.printStackTrace();
		}	
	}

	public void goHomeAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Bulk.getScene().getWindow(),"/fr/kaf/app/fxml/Home.fxml");	
	}
	
	
	
	public void zeroButtonAction(){
		
		quantityFld.setText("");
		priceFld.setText("");
		estimationLbl.setText("");

		/** TODO : vider le tableau, vider l'objet de commande **/
	}
	
	public void addAction(){
		Shoe sample = new Shoe();
		sample.setPlace(placesCbx.getSelectionModel().getSelectedItem());
		sample.setReference(referenceCbx.getValue());
		Order temp = new Order(new Date(),Integer.parseInt(priceFld.getText()),1,sample);
		temp.getResumeInfo().get().put(sample.getReference(), Integer.parseInt(quantityFld.getText()));
		commandTab.getItems().add(temp);
		computeTotalEstimation();
	}
	
	public void confirmAction(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setResizable(false);
		alert.setTitle("Confirmation de Commande");
		alert.setHeaderText("Confirmation");
		alert.setContentText("La commande est-elle complète ?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    try{
		    	for(Order temp : commandTab.getItems()){
		    		daoOrder.create(temp);
		    	}
		    }catch(Exception e){
		    	showException(e);
		    }
		} 
	}
	
	private void computeTotalEstimation() {
		int totalprice = 0;
		for(Order item : commandTab.getItems() )
			totalprice += item.getRealPrice();
		estimationTotalLbl.setText(""+totalprice);
		
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
