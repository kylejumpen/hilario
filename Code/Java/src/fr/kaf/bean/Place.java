package fr.kaf.bean;

import javafx.beans.property.*;

public class Place {
	
	private SimpleBooleanProperty boutique;
	private SimpleStringProperty name;
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public boolean getBoutique() {
		return boutique.get();
	}
	public void setBoutique(boolean boutique) {
		this.boutique.set(boutique);
	}
	
	
}
