package fr.kaf.bean;

import javafx.beans.property.*;

public class Employee extends Person{

	private SimpleIntegerProperty salary;
	private SimpleObjectProperty<Character> droit;
	
	public Employee(){
		super();
		this.salary = new SimpleIntegerProperty();
		this.droit = new SimpleObjectProperty<Character>();
	}
	
	public Employee(int id, String firstName, String lastName, String password, char droits, int salary) {
		super(id,firstName,lastName,password);
		this.salary = new SimpleIntegerProperty(salary);
		this.droit = new SimpleObjectProperty<Character>(droits);
	}
	public int getSalary() {
		return salary.get();
	}
	
	public void setSalary(int salary) {
		this.salary.set(salary);
	}
	
	public char getDroit() {
		return droit.get();
	}
	
	public void setDroit(char droit) {
		this.droit.set(droit);
	}
	
}
