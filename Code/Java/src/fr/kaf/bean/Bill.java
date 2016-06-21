package fr.kaf.bean;

import java.text.SimpleDateFormat;
import java.util.*;

public class Bill {

	private int id;
	private SimpleDateFormat date;
	private String detail;
	private boolean paid;
	private int amout;
	private Person biller;
	
	
	public int getId() {
		return id;
	}
	
	protected void setId(int id) {
		this.id = id;
	}
	
	public SimpleDateFormat getDate() {
		return date;
	}
	
	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public boolean isPaid() {
		return paid;
	}
	
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public int getAmout() {
		return amout;
	}
	
	public void setAmout(int amout) {
		this.amout = amout;
	}
	
	public Person getBiller() {
		return biller;
	}
	
	public void setBiller(Person biller) {
		this.biller = biller;
	}
	
}
