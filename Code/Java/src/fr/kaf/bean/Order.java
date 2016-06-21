package fr.kaf.bean;

import java.text.SimpleDateFormat;
import java.util.List;

public class Order {

	private int id;
	private SimpleDateFormat date;
	private int realPrice;
	private Person seller;
	private List<Shoe> shoes;
	
	public int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
	}
	
	public SimpleDateFormat getDate() {
		return date;
	}
	
	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}
	
	public int getRealPrice() {
		return realPrice;
	}
	
	public void setRealPrice(int realPrice) {
		this.realPrice = realPrice;
	}
	
	public Person getSeller() {
		return seller;
	}
	
	public void setSeller(Person seller) {
		this.seller = seller;
	}

	public List<Shoe> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoe> shoes) {
		this.shoes = shoes;
	}
	
	
	
	
}
