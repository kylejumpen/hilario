package fr.kaf.app.controller.stock;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StockController {

	@FXML
	VBox Stock;
	
	public void goHomeAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/Home.fxml"));
		Stage stage = (Stage) Stock.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
	
	public void goConsultStockAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/stock/ConsultStock.fxml"));
		Stage stage = (Stage) Stock.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
	
	public void goAddStockAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/stock/AddStock.fxml"));
		Stage stage = (Stage) Stock.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
	
	public void closeButtonAction(){
		Stage stage = (Stage) Stock.getScene().getWindow();
		stage.close();
	}
	
}
