package org.totalbeginner.tutorial;

public class Person {
	
	//fields
	private String name;
	private int maximumBooks;
	
	//constructor
	public Person (){
		name="unknown name";
		maximumBooks=3;
	}

	//methods
	public String getName() {
		return name;
	}

	public Person(String name) {
		super();
		this.name = name;
		maximumBooks=3;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaximumBooks() {
		return this.maximumBooks;
	}

	public void setMaximumBooks(int maximumBooks) {
		this.maximumBooks = maximumBooks;
	}

	public String toString() {
		return getName() +" ("+getMaximumBooks()+" books)";
	}
}
