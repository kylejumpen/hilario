package fr.kaf.app.controller.command;

import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UnitController extends DefaultController {

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
		goSmwhereAction((Stage) Unit.getScene().getWindow(),"/fr/kaf/app/fxml/command/Command.fxml");	
	}
	
	public void cancelButtonAction(){
		quantityFld.setText("");
		priceFld.setText("");
		estimationLbl.setText("");
	}
	
}
