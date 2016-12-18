package fr.kaf.app.controller;

import java.io.IOException;

import fr.kaf.dao.DAOFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public abstract class DefaultController {

	protected DAOFactory dFact;
	
	protected String[] months = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août",
			"Septembre","Octobre","Novembre","Décembre"};
	
	public void initialize(){
		try{
		dFact = new DAOFactory();
		}catch(Exception e){
			showException(e);
		}
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
	
	protected void showException(Exception e){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception Dialog");
		alert.setHeaderText("Un problème est apparu");
		alert.setContentText("Le programme est contraint d'être arrêté\n Penser à contacter le concepteur");
		TextArea textArea = new TextArea(e.toString());
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		
		Label label = new Label("L'exception est :");
		
		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
		System.exit(0);
	}
	
}
