package fr.kaf.app.controller.hr;

import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddEmployeeController extends DefaultController {

	@FXML
	VBox AddEmployee;
	
	public void goHRAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) AddEmployee.getScene().getWindow(),"/fr/kaf/app/fxml/hr/HumanRessources.fxml");	
	}
	
}
