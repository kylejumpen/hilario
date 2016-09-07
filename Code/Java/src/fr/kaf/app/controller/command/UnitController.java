package fr.kaf.app.controller.command;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UnitController {

	@FXML
	VBox Unit;
	
	@FXML
	TextField quantityFld;
	
	@FXML
	TextField priceFld;
	
	@FXML
	Button cancelButton;
	
	@FXML
	Label estimationLbl;
	
	public void goCommandAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/command/Command.fxml"));
		Stage stage = (Stage) Unit.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
	
	
	
	public void cancelButtonAction(){
		quantityFld.setText("");
		priceFld.setText("");
		estimationLbl.setText("");
	}
	
}
