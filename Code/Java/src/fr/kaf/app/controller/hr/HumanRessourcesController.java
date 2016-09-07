package fr.kaf.app.controller.hr;

import java.io.IOException;

import fr.kaf.app.controller.DefaultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HumanRessourcesController extends DefaultController{

	@FXML
	VBox HumanRessources;
	
	public void goHomeAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) HumanRessources.getScene().getWindow(),"/fr/kaf/app/fxml/Home.fxml");	
	}
	
	public void goAddEmplAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) HumanRessources.getScene().getWindow(),"/fr/kaf/app/fxml/hr/AddEmployee.fxml");	
	}
	
	public void goConsultHRAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) HumanRessources.getScene().getWindow(),"/fr/kaf/app/fxml/hr/ConsultHR.fxml");	
	}
	
	public void closeButtonAction(){
		super.closeButtonAction((Stage) HumanRessources.getScene().getWindow());
	}
}
