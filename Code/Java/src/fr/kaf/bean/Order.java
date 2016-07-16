package fr.kaf.bean;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

public class Order {

	private SimpleIntegerProperty id;
	private SimpleObjectProperty<Date> date;
	private SimpleIntegerProperty realPrice;
	private SimpleObjectProperty<Person> seller;
	private SimpleListProperty<Shoe> shoes;
	
	public Order(int id, Date date, int realPrice, int seller){
		this.id = new SimpleIntegerProperty(id);
		this.date = new SimpleObjectProperty<>(date);
		this.realPrice = new SimpleIntegerProperty(realPrice);
		this.seller = new SimpleObjectProperty<>();
		this.seller.get().setId(seller);
	}
	
	public int getId() {
		return id.get();
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
	
	public int getRealPrice() {
		return this.realPrice.get();
	}
	
	public void setRealPrice(int realPrice) {
		this.realPrice.set(realPrice);
	}
	
	public Person getSeller() {
		return this.seller.get();
	}
	
	public void setSeller(Person seller) {
		this.seller.set(seller);
	}

	public List<Shoe> getShoes() {
		return shoes.get();
	}

	public void setShoes(List<Shoe> shoes) {
		this.shoes.set(FXCollections.observableList(shoes));
	}
	
	
	
	
}
