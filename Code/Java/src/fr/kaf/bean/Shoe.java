package fr.kaf.bean;

import javafx.beans.property.*;

public class Shoe {

	private SimpleIntegerProperty id;
	private SimpleStringProperty reference;
	private SimpleFloatProperty price;
	private SimpleObjectProperty<Place> place;
	
	public Shoe () {
	this.id = new SimpleIntegerProperty();
	this.reference = new SimpleStringProperty();
	this.price = new SimpleFloatProperty();
	this.place = new SimpleObjectProperty<Place>();
	}
	
	
	public int getId() {
		return id.get();
	}
	
	private void setId(int id) {
		this.id.set(id);
	}
	
	public String getReference() {
		return reference.get();
	}
	
	public void setReference(String reference) {
		this.reference.set(reference);
	}
	
	public float getPrice() {
		return price.get();
	}
	
	public void setPrice(float price) {
		this.price.set(price);
	}
	
	public Place getPlace() {
		return this.place.get();
	}
	
	public void setPlace(Place place) {
		this.setPlace(place);
	}
}
