package fr.kaf.bean;

import javafx.beans.property.*;
import java.text.SimpleDateFormat;

public class Bill {

	private SimpleIntegerProperty id;
	private SimpleObjectProperty<SimpleDateFormat> date;
	private SimpleStringProperty detail;
	private SimpleBooleanProperty paid;
	private SimpleIntegerProperty amount;
	private SimpleObjectProperty<Person> biller;
	
	public Bill(){
		this.id = new SimpleIntegerProperty();
		this.date = new SimpleObjectProperty<SimpleDateFormat>();
		this.detail = new SimpleStringProperty();
		this.paid = new SimpleBooleanProperty();
		this.amount = new SimpleIntegerProperty();
		this.biller = new SimpleObjectProperty<Person>();
	}
	
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
	
	public Integer getAmout() {
		return amount.get();
	}
	
	public void setAmout(int amout) {
		this.amount.set(amout);
	}
	
	public Person getBiller() {
		return biller.get();
	}
	
	public void setBiller(Person biller) {
		this.biller.set(biller);
	}
	
	
	
}
