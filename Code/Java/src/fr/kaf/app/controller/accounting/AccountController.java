package fr.kaf.app.controller.accounting;

import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountController extends DefaultController {

	@FXML
	VBox Account;
	
	@FXML
	ToggleGroup periodRadio;
	
	public void goAccountingAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Account.getScene().getWindow(),"/fr/kaf/app/fxml/accounting/Accounting.fxml");		
	}
	
}
