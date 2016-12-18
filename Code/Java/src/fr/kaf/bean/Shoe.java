package fr.kaf.bean;

import javafx.beans.property.*;

public class Shoe {

	private SimpleIntegerProperty id;
	private SimpleStringProperty reference;
	private SimpleFloatProperty price;
	private SimpleObjectProperty<Place> place;
	private SimpleObjectProperty<Order> order;
	private SimpleObjectProperty<Bulk> bulk;
	
	public Shoe () {
	this.id = new SimpleIntegerProperty();
	this.reference = new SimpleStringProperty();
	this.price = new SimpleFloatProperty();
	this.place = new SimpleObjectProperty<Place>(new Place());
	this.order = new SimpleObjectProperty<Order>();
	this.bulk = new SimpleObjectProperty<Bulk>(new Bulk());
	}
	
	public Shoe(String reference, float price, Place place){
		this.reference = new SimpleStringProperty(reference);
		this.price = new SimpleFloatProperty(price);
		this.place = new SimpleObjectProperty<Place>(place);
		this.order = new SimpleObjectProperty<Order>();
		this.bulk = new SimpleObjectProperty<>(new Bulk());
	}
	
	public Shoe(int id, String reference, float price, String place, int order, int bulk){
		this.id = new SimpleIntegerProperty(id);
		this.reference = new SimpleStringProperty(reference);
		this.price = new SimpleFloatProperty(price);
		this.place = new SimpleObjectProperty<Place>();
		this.place.get().setName(place);
		this.order = new SimpleObjectProperty<Order>();
		this.order.get().setId(order);
		this.bulk = new SimpleObjectProperty<Bulk>(new Bulk());
		this.bulk.get().setId(bulk);
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
		this.place.set(place);
	}
	
	public Order getOrder() {
		return this.order.get();
	}
	
	public void setOrder(Order order) {
		this.order.set(order);
	}
	
	public Bulk getBulk() {
		return this.bulk.get();
	}
	
	public void setBulk(Bulk bulk) {
		this.bulk.set(bulk);
	}
}
