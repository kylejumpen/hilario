package fr.kaf.app.controller.hr;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddEmployeeController {

	@FXML
	VBox AddEmployee;
	
	public void goHRAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/hr/HumanRessources.fxml"));
		Stage stage = (Stage) AddEmployee.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
	
}
