package fr.kaf.app.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeController extends DefaultController {
	
	@FXML
	VBox Home;
	
	public void goCommandAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage)Home.getScene().getWindow(),"/fr/kaf/app/fxml/command/Command.fxml");
	}
	
	public void goAccountingAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage)Home.getScene().getWindow(),"/fr/kaf/app/fxml/accounting/Accounting.fxml");
	}
		
	public void goStockAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage)Home.getScene().getWindow(),"/fr/kaf/app/fxml/stock/Stock.fxml");	
	}
	
	public void goHumanRessourcesAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage)Home.getScene().getWindow(),"/fr/kaf/app/fxml/hr/HumanRessources.fxml");		
	}
	
	public void closeButtonAction(ActionEvent e){
		super.closeButtonAction((Stage)Home.getScene().getWindow());
	}
}
