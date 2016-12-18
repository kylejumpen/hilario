package fr.kaf.app.controller.accounting;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.kaf.app.controller.DefaultController;
import fr.kaf.bean.StatAccount;
import fr.kaf.dao.implement.StatAccountDAO;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountController extends DefaultController implements Initializable {

	@FXML
	VBox Account;
	
	@FXML
	TableView<StatAccount> accountTab;
	
	@FXML
	TableColumn<StatAccount,String> periodCol;
	
	@FXML
	TableColumn<StatAccount,Integer> sellCol;
	
	@FXML
	TableColumn<StatAccount,Float> expenseCol;
	
	@FXML
	TableColumn<StatAccount,Float> benefitCol;
	
	@FXML
	ToggleGroup periodRadio;
	
	StatAccountDAO daoStatAcc;
	
	SimpleListProperty<StatAccount> stats;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		super.initialize();
		stats = new SimpleListProperty<StatAccount>();
		daoStatAcc = (StatAccountDAO) dFact.getStatAccountDAO();
		try {
			stats = daoStatAcc.findAll();
			accountTab.setItems(stats);
		} catch (SQLException e) {
			showException(e);
			e.printStackTrace();
		}
		periodCol.setCellValueFactory((cellData) -> new SimpleStringProperty(months[cellData.getValue().getPeriod() - 1]));
		sellCol.setCellValueFactory(new PropertyValueFactory<StatAccount,Integer>("totalOrd"));
		expenseCol.setCellValueFactory(new PropertyValueFactory<StatAccount,Float>("totalBlk"));
		benefitCol.setCellValueFactory((cellData) -> new SimpleFloatProperty(cellData.getValue().getTotalOrd() - (cellData.getValue().getTotalBlk() + cellData.getValue().getTotalBill())).asObject());
	}
	
	public void goAccountingAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Account.getScene().getWindow(),"/fr/kaf/app/fxml/accounting/Accounting.fxml");		
	}
	
}
