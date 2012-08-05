package org.totalbeginner.tutorial;

import java.util.ArrayList;

public class myLibrary {

	private String name;
	public ArrayList<Person> people;
	public ArrayList<Book> books;

	public myLibrary(String string) {
		this.name=string;
		books=new ArrayList<Book>();
		people=new ArrayList<Person>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void addBook(Book b1) {

		this.books.add(b1);
		
	}

	public void removeBook(Book b1) {
		this.books.remove(b1);
		
	}

	public void addPerson(Person p1) {
		this.people.add(p1);
		
	}

	public void removePerson(Person p1) {
		
		this.people.remove(p1);
		
	}

	public boolean checkOut(Book b1,Person p1) {

		int howManyBooksPersonHave=this.getBookForPersons(p1).size();
		
		if(b1.getPerson()==null && howManyBooksPersonHave<p1.getMaximumBooks()){
			b1.setPerson(p1);
			System.out.println("cekouttru");
			return true;
		}
			
		else {
			System.out.println("cekoufalse");
			return false;
		}
		
	}

	public boolean checkIn(Book b1) {
		if(b1.getPerson()!=null){
			b1.setPerson(null);
			return true;
		}
			
		else return false;
	}

	public ArrayList<Book> getBookForPersons(Person p1) {
		
		ArrayList<Book> booksForPerson=new ArrayList<Book>();
		
		for (Book book : this.books) {
			
			if(book.getPerson()==p1){
			
				booksForPerson.add(book);
			}
				
		}
		return booksForPerson;
	}

	public ArrayList<Book> getAvailableBooks() {

		ArrayList<Book> availableBooks=new ArrayList<Book>();
		
		for (Book book : this.books) {
			
			if(book.getPerson()==null){
			
				availableBooks.add(book);
			}
				
		}
		return availableBooks;
	}

	public ArrayList<Book> getUnavailableBooks() {

		ArrayList<Book> unAvailableBooks=new ArrayList<Book>();
		
		for (Book book : this.books) {
			
			if(book.getPerson()!=null){
			
				unAvailableBooks.add(book);
			}
				
		}
		return unAvailableBooks;
	}
	
	public String toString() {
		 
		String available;
		
		available=this.name + ": " +this.getPeople().size()+" People and "
					+this.books.size()+" Books";
		return available;
	}
	
	public static void main(String[] args) {
		
		myLibrary testLibrary = new myLibrary("Test Drive Library");
		Book b1 = new Book("War and Peace");
		Book b2 = new Book("Great Expectations");
		 b1.setAuthor("Tolstoy");
		 b2.setAuthor("Dickens");
		 
		 testLibrary.addBook(b1);
		 testLibrary.addBook(b2);
		 
		 
		 
		 Person sue = new Person("Sue");
		 Person jim = new Person("Jim");
		 
		 testLibrary.addPerson(jim);
		 testLibrary.addPerson(sue);
		 
		 System.out.println("Just Created a New Libraty");
		 testLibrary.printStatus();
		 
		 System.out.println("Check out War and Peace to Sue");
		 
		 testLibrary.checkOut(b1, sue);
		 testLibrary.printStatus();
		 
		 System.out.println("Do some more stuff");
		 testLibrary.checkIn(b1);
		 testLibrary.checkOut(b2, jim);
		 testLibrary.printStatus();
		 
		 
		 
		 
		
	}

	private void printStatus() {
		System.out
				.println("Status Report of My Library \n " + this.toString());
		
		for (Book myBook : this.getBooks()) {
			System.out.println(myBook);
		}
		for (Person  p : this.getPeople()) {
			int count=getBookForPersons(p).size();
			System.out.println(p+" has "+ count +" of my Books");
		
		}
		
		System.out.println("Available Books: "+getAvailableBooks().size());
		System.out.println("Unavailable Books: "+getUnavailableBooks().size());
		
		System.out.println("\n---------End of status-------\n");
		
		
	}


}
