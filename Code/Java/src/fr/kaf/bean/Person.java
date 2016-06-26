package fr.kaf.bean;

import javafx.beans.property.*;

public class Person {

	protected SimpleIntegerProperty id;
	protected SimpleStringProperty firstName;
	protected SimpleStringProperty lastName;
	
	public Person(){
	this.id = new SimpleIntegerProperty();
	this.firstName = new SimpleStringProperty();
	this.lastName = new SimpleStringProperty();	
	}
	
	public int getId() {
		return id.get();
	}
	
	protected void setId(int id) {
		this.id.set(id);
	}
	
	public String getFirstName() {
		return firstName.get();
	}
	
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
	
	public String getLastName() {
		return this.lastName.get();
	}
	
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
	
}
