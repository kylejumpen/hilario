package fr.kaf.bean;

import javafx.beans.property.*;

public class Person {

	protected SimpleIntegerProperty id;
	protected SimpleStringProperty firstName;
	protected SimpleStringProperty lastName;
	protected SimpleStringProperty password;
	
	public Person(){
	this.id = new SimpleIntegerProperty();
	this.firstName = new SimpleStringProperty();
	this.lastName = new SimpleStringProperty();	
	this.password = new SimpleStringProperty();
	}
	
	public Person(int id, String firstName, String lastName, String password){
		this. id = new SimpleIntegerProperty(id);
		this. firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.password = new SimpleStringProperty(password);
	}
	
	public Person(String firstName, String lastName, String password){
		this. firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.password = new SimpleStringProperty(password);
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

	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}
	
}
