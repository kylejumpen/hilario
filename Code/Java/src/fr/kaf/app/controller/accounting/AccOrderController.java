package fr.kaf.app.controller.accounting;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import fr.kaf.app.controller.DefaultController;
import fr.kaf.bean.Order;
import fr.kaf.dao.implement.OrderDAO;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//TODO Modale avec détail de la commande
public class AccOrderController extends DefaultController implements Initializable {

	@FXML
	VBox AccOrder;
	
	@FXML
	ComboBox<String> monthCbx;
	
	@FXML
	TableView<Order> accOrdTab;
	
	@FXML
	TableColumn<Order,Integer> idOrdCol;
	
	@FXML
	TableColumn<Order,Integer> priceOrdCol;
	
	@FXML
	TableColumn<Order,Date> dateOrdCol;
	
	@FXML
	ToggleGroup typePeriodGrp;
	
	OrderDAO daoOrder;
	
	SimpleListProperty<Order> orders;
	
	//TODO Initialiser avec les commande du mois en cours uniquement
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		super.initialize();
		orders = new SimpleListProperty<>();
		daoOrder = (OrderDAO) dFact.getOrderDAO();
		try {
			orders = daoOrder.findAll();
			idOrdCol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
			priceOrdCol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("realPrice"));
			dateOrdCol.setCellValueFactory(new PropertyValueFactory<Order, Date>("date"));
			accOrdTab.setItems(orders);
			monthCbx.setItems(FXCollections.observableArrayList(Arrays.asList(months)));
		} catch (SQLException e) {
			showException(e);
			e.printStackTrace();
		}
		
	}
	
	public void changePeriodAction(){
		if(typePeriodGrp.getToggles().get(1).equals(typePeriodGrp.selectedToggleProperty().get())){
			monthCbx.setDisable(false);
			monthCbx.getSelectionModel().select(Calendar.getInstance().get(Calendar.MONTH));
			changeMonthAction();
		}else{
			monthCbx.setDisable(true);
			orders.clear(); 
			try {
				orders.set(daoOrder.findAll());
			} catch (SQLException e) {
				showException(e);
				e.printStackTrace();
			}
		}
	}
	
	public void changeMonthAction(){
		try {
			orders.clear(); 
			orders.set(daoOrder.findByMonth(monthCbx.getSelectionModel().getSelectedIndex() + 1));	
		} catch (SQLException e) {
			showException(e);
			e.printStackTrace();
		}
	}
	
	public void goAccounting(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) AccOrder.getScene().getWindow(),"/fr/kaf/app/fxml/accounting/Accounting.fxml");		
	}

}
