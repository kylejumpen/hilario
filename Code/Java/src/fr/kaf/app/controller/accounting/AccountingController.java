package fr.kaf.app.controller.accounting;

import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountingController extends DefaultController {
	
	@FXML
	VBox Accounting;
	
	public void goHomeAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Accounting.getScene().getWindow(),"/fr/kaf/app/fxml/Home.fxml");	
	}
	
	public void goAccOrderAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Accounting.getScene().getWindow(),"/fr/kaf/app/fxml/accounting/AccOrder.fxml");			
	}
	
	public void goSupplyAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Accounting.getScene().getWindow(),"/fr/kaf/app/fxml/accounting/Supply.fxml");				
	}
	
	public void goAccountAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Accounting.getScene().getWindow(),"/fr/kaf/app/fxml/accounting/Account.fxml");			
	}
	
	public void closeButtonAction(){
		super.closeButtonAction((Stage) Accounting.getScene().getWindow());
	}
}
