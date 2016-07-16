package fr.kaf.bean;

import java.text.SimpleDateFormat;
import java.util.*;

import javafx.beans.property.*;
import javafx.collections.FXCollections;

public class Bulk {

	private SimpleIntegerProperty id;
	private SimpleObjectProperty<Date> date;
	private SimpleObjectProperty<Person> buyer;
	private SimpleObjectProperty<Person> provider;
	private SimpleListProperty<Shoe> shoes;
	
	public Bulk(){
		this.id = new SimpleIntegerProperty();
		this.date = new SimpleObjectProperty<>();
		this.buyer = new SimpleObjectProperty<>();
		this.provider = new SimpleObjectProperty<>();
		this.shoes = new SimpleListProperty<>();
	}
	
	public Bulk(int id, Date date, int idBuyer, int idProvider){
		this.id = new SimpleIntegerProperty(id);
		this.date = new SimpleObjectProperty<>(date);
		this.buyer = new SimpleObjectProperty<>();
		this.getBuyer().setId(idBuyer);
		this.provider = new SimpleObjectProperty<>();
		this.getProvider().setId(idProvider);
		this.shoes = new SimpleListProperty<>();
	}
	
	public int getId() {
		return this.id.get();
	}
	
	public void setId(int id) {
		this.id.set(id);
	}
	
	public Date getDate() {
		return date.get();
	}
	
	public void setDate(Date date) {
		this.date.set(date);
	}
	
	public Person getBuyer() {
		return buyer.get();
	}
	
	public void setBuyer(Person buyer) {
		this.buyer.set(buyer);
	}

	
	public Person getProvider() {
		return provider.get();
	}
	
	public void setProvider(Person provider) {
		this.buyer.set(provider);
	}
	
	public List<Shoe> getShoes() {
		return shoes.get();
	}

	public void setShoes(List<Shoe> shoes) {
		this.shoes.set(FXCollections.observableList(shoes));
	}
	
}
