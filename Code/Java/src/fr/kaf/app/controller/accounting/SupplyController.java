package fr.kaf.app.controller.accounting;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SupplyController {

	@FXML
	HBox Supply;
	
	public void goAccounting(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/accounting/Accounting.fxml"));
		Stage stage = (Stage) Supply.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();			
	}
}
