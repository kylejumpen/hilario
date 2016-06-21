package fr.kaf.bean;

public class Employee extends Person{

	private int salary;
	private char droit;
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public char getDroit() {
		return droit;
	}
	
	public void setDroit(char droit) {
		this.droit = droit;
	}
	
}
