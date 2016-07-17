package fr.kaf.app.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeController {
	
	@FXML
	Button closeButton;
	
	@FXML
	VBox Home;
	
	public void goCommand(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/Command.fxml"));
		Stage stage = (Stage) Home.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
	
	public void goAccounting(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/Accounting.fxml"));
		Stage stage = (Stage) Home.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();	
	}
	
	
	
	public void goStock(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/Stock.fxml"));
		Stage stage = (Stage) Home.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();	
	}
	
	public void goHumanRessources(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/HumanRessources.fxml"));
		Stage stage = (Stage) Home.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();		
	}
	
	public void closeButtonAction(){
		Stage stage = (Stage) Home.getScene().getWindow();
		stage.close();
	}
	
}
