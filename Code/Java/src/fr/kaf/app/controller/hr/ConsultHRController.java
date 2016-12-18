package fr.kaf.app.controller.hr;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.kaf.app.controller.DefaultController;
import fr.kaf.bean.Employee;
import fr.kaf.dao.DAO;
import fr.kaf.dao.implement.EmployeeDAO;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsultHRController extends DefaultController implements Initializable{

	@FXML
	VBox ConsultHR;
	
	@FXML
	public TableView<Employee> table;
	
	@FXML
	TableColumn<Employee,String> firstNameCol;
	
	@FXML
	TableColumn<Employee,String> lastNameCol;
	
	@FXML
	TextField firstNameFld;
	
	@FXML
	TextField lastNameFld;
	
	@FXML
	TextField salaryFld;
	
	EmployeeDAO daoEmployee;
	
	SimpleListProperty<Employee> employees;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources){
		super.initialize();
		daoEmployee = (EmployeeDAO) dFact.getEmployeeDAO();
		try {
			employees = daoEmployee.findAll();
			System.out.println(employees.get());
			if(employees.size() > 0)
				table.setItems(employees);
			firstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
			lastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
			table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showEmployeeDetails(newValue));
		} catch (SQLException e) {
			showException(e);
			e.printStackTrace();
		}
		
	}
	
	public void goHRAction(ActionEvent e) throws IOException{
		goSmwhereAction((Stage) ConsultHR.getScene().getWindow(),"/fr/kaf/app/fxml/hr/HumanRessources.fxml");	
	}
	
	private void showEmployeeDetails(Employee emp){
		if(emp != null){
		firstNameFld.setText(emp.getFirstName());
		lastNameFld.setText(emp.getLastName());
		salaryFld.setText("" +emp.getSalary());
		}else{
			firstNameFld.setText("");
			lastNameFld.setText("");
			salaryFld.setText("");			
		}
	}
	
	public void modifyEmployeeDetails(ActionEvent e){
		table.setDisable(!table.isDisable());
		firstNameFld.setDisable(false);
		firstNameFld.setEditable(true);
		lastNameFld.setDisable(false);
		lastNameFld.setEditable(true);
		salaryFld.setDisable(false);
		salaryFld.setEditable(true);
	}
	
	public void saveEmployeeDetails(ActionEvent e){
		Employee temp = employees.get(employees.get().indexOf(table.getSelectionModel().selectedItemProperty().get()));
		table.setDisable(!table.isDisable());
		firstNameFld.setDisable(true);
		firstNameFld.setEditable(false);
		temp.setFirstName(firstNameFld.getText());
		lastNameFld.setDisable(true);
		lastNameFld.setEditable(false);
		temp.setLastName(lastNameFld.getText());
		salaryFld.setDisable(true);
		salaryFld.setEditable(false);
		temp.setSalary(Integer.parseInt(salaryFld.getText()));
		try {
			daoEmployee.update(temp);
		} catch (SQLException e1) {
			// TODO Mettre un message de feedback
			e1.printStackTrace();
		}
	}
	
	public void removeEmployeeDetails(ActionEvent e){
		try {
			daoEmployee.delete(table.getSelectionModel().selectedItemProperty().get());
			employees.remove(table.getSelectionModel().selectedItemProperty().get());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
