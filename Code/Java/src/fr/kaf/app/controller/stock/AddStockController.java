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

public class AddStockController {
	
	@FXML
	VBox AddStock;
	
	public void goStockAction(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/fr/kaf/app/fxml/stock/Stock.fxml"));
		Stage stage = (Stage) AddStock.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();
	}
}
