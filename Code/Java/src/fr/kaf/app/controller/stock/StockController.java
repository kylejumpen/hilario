package fr.kaf.app.controller.stock;

import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StockController extends DefaultController {

	@FXML
	VBox Stock;
	
	public void goHomeAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Stock.getScene().getWindow(),"/fr/kaf/app/fxml/Home.fxml");	
	}
	
	public void goConsultStockAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Stock.getScene().getWindow(),"/fr/kaf/app/fxml/stock/ConsultStock.fxml");	
	}
	
	public void goAddStockAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Stock.getScene().getWindow(),"/fr/kaf/app/fxml/stock/AddStock.fxml");
	}
	
	public void closeButtonAction(){
		super.closeButtonAction((Stage) Stock.getScene().getWindow());
	}
	
}
