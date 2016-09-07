package fr.kaf.app.controller.command;


import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CommandController extends DefaultController {

	@FXML
	VBox Command;
	
	public void goHomeAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Command.getScene().getWindow(),"/fr/kaf/app/fxml/Home.fxml");	
	}
	
	public void goUnitAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Command.getScene().getWindow(),"/fr/kaf/app/fxml/command/Unit.fxml");	
	}
	
	public void goBulkAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) Command.getScene().getWindow(),"/fr/kaf/app/fxml/command/Bulk.fxml");		
	}
	
	
	public void closeButtonAction(){
		super.closeButtonAction((Stage) Command.getScene().getWindow());
	}
	
	
}
