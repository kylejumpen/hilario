package fr.kaf.bean;

import java.text.SimpleDateFormat;
import java.util.*;

import javafx.beans.property.*;
import javafx.collections.FXCollections;

public class Bulk {

	private SimpleIntegerProperty id;
	private SimpleObjectProperty<SimpleDateFormat> date;
	private SimpleObjectProperty<Person> buyer;
	private SimpleListProperty<Shoe> shoes;
	
	public Bulk(){
		this.id = new SimpleIntegerProperty();
		this.date = new SimpleObjectProperty<SimpleDateFormat>();
		this.buyer = new SimpleObjectProperty<Person>();
		this.setShoes(new SimpleListProperty<Shoe>());
	}
	
	public int getId() {
		return this.id.get();
	}
	
	public void setId(int id) {
		this.id.set(id);
	}
	
	public SimpleDateFormat getDate() {
		return date.get();
	}
	
	public void setDate(SimpleDateFormat date) {
		this.date.set(date);
	}
	
	public Person getBuyer() {
		return buyer.get();
	}
	
	public void setBuyer(Person buyer) {
		this.buyer.set(buyer);
	}

	public List<Shoe> getShoes() {
		return shoes.get();
	}

	public void setShoes(List<Shoe> shoes) {
		this.shoes.set(FXCollections.observableList(shoes));
	}
	
}
