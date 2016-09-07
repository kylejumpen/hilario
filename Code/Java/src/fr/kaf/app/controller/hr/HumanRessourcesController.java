package fr.kaf.app.controller.hr;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HumanRessourcesController {

	@FXML
	VBox HumanRessources;
	
	public void goHomeAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/Home.fxml"));
		Stage stage = (Stage) HumanRessources.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
	
	public void goAddEmplAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/hr/AddEmployee.fxml"));
		Stage stage = (Stage) HumanRessources.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
	
	public void goConsultHRAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/hr/ConsultHR.fxml"));
		Stage stage = (Stage) HumanRessources.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
	
	public void closeButtonAction(){
		Stage stage = (Stage) HumanRessources.getScene().getWindow();
		stage.close();
	}
}
