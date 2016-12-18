package fr.kaf.bean;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class StatAccount {

	private SimpleIntegerProperty period;
	private SimpleIntegerProperty totalOrd;
	private SimpleIntegerProperty nbOrd;
	private SimpleFloatProperty totalBlk;
	private SimpleIntegerProperty nbBlk;
	private SimpleIntegerProperty totalBill;
	private SimpleIntegerProperty nbBill;
	
	public StatAccount(){
		this.period = new SimpleIntegerProperty(0);
		this.totalOrd = new SimpleIntegerProperty(0);
		this.nbOrd = new SimpleIntegerProperty(0);
		this.totalBlk = new SimpleFloatProperty(0);
		this.nbBlk = new SimpleIntegerProperty(0);
		this.totalBill = new SimpleIntegerProperty(0);
		this.nbBill = new SimpleIntegerProperty(0);
	}

	public int getPeriod() {
		return period.get();
	}

	public void setPeriod(int period) {
		this.period.set(period);
	}

	public int getTotalOrd() {
		return totalOrd.get();
	}

	public void setTotalOrd(int totalOrd) {
		this.totalOrd.set(totalOrd);
	}

	public int getNbOrd() {
		return nbOrd.get();
	}

	public void setNbOrd(int nbOrd) {
		this.nbOrd.set(nbOrd);
	}

	public float getTotalBlk() {
		return totalBlk.get();
	}

	public void setTotalBlk(float totalBlk) {
		this.totalBlk.set(totalBlk);
	}

	public int getNbBlk() {
		return nbBlk.get();
	}

	public void setNbBlk(int nbBlk) {
		this.nbBlk.set(nbBlk);
	}

	public int getTotalBill() {
		return totalBill.get();
	}

	public void setTotalBill(int totalBill) {
		this.totalBill.set(totalBill);
	}

	public int getNbBill() {
		return nbBill.get();
	}

	public void setNbBill(int nbBill) {
		this.nbBill.set(nbBill);
	}
	
}
