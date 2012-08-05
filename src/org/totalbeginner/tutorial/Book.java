package org.totalbeginner.tutorial;

public class Book {

	public String title;
	public String author;
	private Person person;

	public Book(String string) {
		this.author="Unknown Author";
		this.title=string;
	}	

	

	public String getTitle() {
		return title;
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPerson(Person p1) {
		this.person=p1;
		
	}

	public Person getPerson() {
		
		return this.person;
	}
	 
	public String toString() {
		 
		String available;
		
		if(this.getPerson()==null)
			available="Available";
		else
			available="Checked Out by " +this.getPerson().getName();
		return this.getTitle() + " by " +this.getAuthor() +" ; " +available;
	}

}
