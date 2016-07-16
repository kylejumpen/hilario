package fr.kaf.bean;

import javafx.beans.property.*;

import java.util.Date;

public class Bill {

	private SimpleIntegerProperty id;
	private SimpleObjectProperty<Date> date;
	private SimpleStringProperty detail;
	private SimpleBooleanProperty paid;
	private SimpleLongProperty amount;
	private SimpleObjectProperty<Person> biller;
	
	public Bill(){
		this.id = new SimpleIntegerProperty();
		this.date = new SimpleObjectProperty<Date>();
		this.detail = new SimpleStringProperty();
		this.paid = new SimpleBooleanProperty();
		this.amount = new SimpleLongProperty();
		this.biller = new SimpleObjectProperty<Person>();
	}
	
	public Bill(int id, Date date, String details, boolean paid, long amount, SimpleObjectProperty<Person> biller){
		this.id = new SimpleIntegerProperty(id);
		this.date = new SimpleObjectProperty<Date>(date);
		this.detail = new SimpleStringProperty(details);
		this.paid = new SimpleBooleanProperty(paid);
		this.amount = new SimpleLongProperty(amount);
		this.biller = new SimpleObjectProperty<Person>();
		this.biller = biller;
	}

	public Bill(Date date, String details, boolean paid, long amount, SimpleObjectProperty<Person> biller){
		this.id = new SimpleIntegerProperty();
		this.date = new SimpleObjectProperty<Date>(date);
		this.detail = new SimpleStringProperty(details);
		this.paid = new SimpleBooleanProperty(paid);
		this.amount = new SimpleLongProperty(amount);
		this.biller = new SimpleObjectProperty<Person>();
		this.biller = biller;
	}
	
	public int getId() {
		return id.get();
	}
	
	private void setId(int id) {
		this.id.set(id);
	}
	
	public Date getDate() {
		return date.get();
	}
	
	public void setDate(Date date) {
		this.date.set(date);
	}
	
	public String getDetail() {
		return detail.get();
	}
	
	public void setDetail(String detail) {
		this.detail.set(detail);
	}
	
	public Boolean getPaid() {
		return paid.get();
	}
	
	public void setPaid(boolean paid) {
		this.paid.get();
	}
	
	public long getAmout() {
		return amount.get();
	}
	
	public void setAmout(long amout) {
		this.amount.set(amout);
	}
	
	public SimpleObjectProperty<Person> getBiller() {
		return biller;
	}
	
	public void setBiller(SimpleObjectProperty<Person> biller) {
		this.biller = biller;
	}
	
	
	
}
