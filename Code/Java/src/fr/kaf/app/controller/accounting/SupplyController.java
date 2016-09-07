package fr.kaf.app.controller.accounting;

import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SupplyController extends DefaultController {

	@FXML
	HBox Supply;
	
	public void goAccounting(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Supply.getScene().getWindow(),"/fr/kaf/app/fxml/accounting/Accounting.fxml");				
	}
}
