package fr.kaf.app.controller.stock;

import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsultStockController extends DefaultController {

	@FXML
	VBox ConsultStock;
	
	public void goStockAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) ConsultStock.getScene().getWindow(),"/fr/kaf/app/fxml/stock/Stock.fxml");	
	}
}
