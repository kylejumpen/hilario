package fr.kaf.app.controller.accounting;

import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AccOrderController extends DefaultController {

	@FXML
	VBox AccOrder;
	
	public void goAccounting(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) AccOrder.getScene().getWindow(),"/fr/kaf/app/fxml/accounting/Accounting.fxml");		
	}
}
