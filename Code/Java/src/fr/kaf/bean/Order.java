package fr.kaf.bean;

import java.text.SimpleDateFormat;
import java.util.List;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

public class Order {

	private SimpleIntegerProperty id;
	private SimpleObjectProperty<SimpleDateFormat> date;
	private SimpleIntegerProperty realPrice;
	private SimpleObjectProperty<Person> seller;
	private SimpleListProperty<Shoe> shoes;
	
	public int getId() {
		return id.get();
	}
	
	private void setId(int id) {
		this.id.set(id);
	}
	
	public SimpleDateFormat getDate() {
		return date.get();
	}
	
	public void setDate(SimpleDateFormat date) {
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
