package fr.kaf.bean;

import java.text.SimpleDateFormat;
import java.util.*;

public class Bulk {

	private int id;
	private SimpleDateFormat date;
	private Person Buyer;
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
	
	public Person getBuyer() {
		return Buyer;
	}
	
	public void setBuyer(Person buyer) {
		Buyer = buyer;
	}
}
