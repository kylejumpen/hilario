package fr.kaf.app.controller.command;

import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BulkController extends DefaultController {

	@FXML
	VBox Bulk;
	
	@FXML
	TextField quantityFld;
	
	@FXML
	TextField priceFld;
	
	@FXML
	Label estimationLbl;
	
	@FXML
	TreeTableView commandTab;
	

	public void goCommandAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Bulk.getScene().getWindow(),"/fr/kaf/app/fxml/command/Command.fxml");	
	}
	
	
	
	public void zeroButtonAction(){
		
		quantityFld.setText("");
		priceFld.setText("");
		estimationLbl.setText("");
		
		/** TO-DO : vider le tableau, vider l'objet de commande **/
	}
}
