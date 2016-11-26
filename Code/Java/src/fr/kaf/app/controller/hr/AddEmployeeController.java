package fr.kaf.app.controller.hr;

import java.io.IOException;
import java.sql.SQLException;

import fr.kaf.app.controller.DefaultController;
import fr.kaf.bean.Employee;
import fr.kaf.dao.DAO;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddEmployeeController extends DefaultController {

	@FXML
	VBox AddEmployee;
	
	@FXML
	TextField firstNameTxt;
	
	@FXML
	TextField lastNameTxt;
	
	@FXML
	DatePicker birthDateTxt;
	
	@FXML
	TextField salaryTxt;
	
	@FXML
	Label feedBackLbl;
	
	DAO<Employee> dao;
	
	@SuppressWarnings("unchecked")
	public void initialize(){
		super.initialize();
		dao = (DAO<Employee>) dFact.getEmployeeDAO();
	}
	
	public void saveEmployee(Event e){
		
		Employee temp = new Employee(firstNameTxt.getText(),lastNameTxt.getText(),"eavae",'e',Integer.parseInt(salaryTxt.getText()));
		feedBackLbl.setText("Opération en cours, ne pas quitter");
		feedBackLbl.setTextFill(Color.RED);
		try {
			dao.create(temp);
			feedBackLbl.setTextFill(Color.GREEN);
			feedBackLbl.setText("Employé ajouté");
		} catch (SQLException e1) {
			feedBackLbl.setText("Erreur de connexion à la base");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public void goHRAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) AddEmployee.getScene().getWindow(),"/fr/kaf/app/fxml/hr/HumanRessources.fxml");	
	}
	
}
