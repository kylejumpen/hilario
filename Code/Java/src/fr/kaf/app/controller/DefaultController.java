package fr.kaf.app.controller;

import java.io.IOException;

import fr.kaf.dao.DAOFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class DefaultController {

	protected DAOFactory dFact;
	
	public void initialize(){
		dFact = new DAOFactory();
	}
	
	protected void goSmwhereAction(Stage currentStage,String targetFxml) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource(targetFxml));
		Stage stage = (Stage) currentStage.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.sizeToScene();	
	}
	
	protected void closeButtonAction(Stage currentStage){
		Stage stage = (Stage) currentStage.getScene().getWindow();
		stage.close();
	}
	
}
