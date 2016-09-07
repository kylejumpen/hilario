package fr.kaf.app.controller.command;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CommandController {

	@FXML
	VBox Command;
	
	public void goHomeAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/Home.fxml"));
		Stage stage = (Stage) Command.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
	
	public void goUnitAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/command/Unit.fxml"));
		Stage stage = (Stage) Command.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();	
	}
	
	public void goBulkAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/command/Bulk.fxml"));
		Stage stage = (Stage) Command.getScene().getWindow();
		stage.hide();
		stage.setScene(new Scene(root));
		stage.show();
		stage.sizeToScene();		
	}
	
	
	public void closeButtonAction(){
		Stage stage = (Stage) Command.getScene().getWindow();
		stage.close();
	}
	
	
}
