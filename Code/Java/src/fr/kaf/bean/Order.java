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
	private SimpleObjectProperty<Shoe> sampleShoe;
	private SimpleObjectProperty<HashMap<String,Integer>> resumeInfo;
	
	public Order(int id, Date date, int realPrice, int seller){
		this.id = new SimpleIntegerProperty(id);
		this.date = new SimpleObjectProperty<>(date);
		this.realPrice = new SimpleIntegerProperty(realPrice);
		this.seller = new SimpleObjectProperty<>(new Person());
		this.seller.get().setId(seller);
		this.sampleShoe = new SimpleObjectProperty<>(new Shoe());
		this.resumeInfo = new SimpleObjectProperty<>(new HashMap<>());
	}
	
	public Order(Date date, int realPrice, int seller,Shoe sampleShoe){
		this.id = new SimpleIntegerProperty(0);
		this.date = new SimpleObjectProperty<>(date);
		this.realPrice = new SimpleIntegerProperty(realPrice);
		this.seller = new SimpleObjectProperty<>(new Person());
		this.seller.get().setId(seller);
		this.sampleShoe = new SimpleObjectProperty<>(sampleShoe);
		this.resumeInfo = new SimpleObjectProperty<>(new HashMap<>());
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

	public SimpleObjectProperty<HashMap<String,Integer>> getResumeInfo() {
		return resumeInfo;
	}

	public void setResumeInfo(HashMap<String,Integer> resumeInfo) {
		this.resumeInfo.set(resumeInfo);
	}

	public SimpleObjectProperty<Shoe> getSampleShoe() {
		return sampleShoe;
	}

	public void setSampleShoe(SimpleObjectProperty<Shoe> sampleShoe) {
		this.sampleShoe = sampleShoe;
	}
	
}
