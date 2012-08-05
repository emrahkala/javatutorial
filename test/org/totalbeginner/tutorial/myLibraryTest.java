package org.totalbeginner.tutorial;

import java.util.ArrayList;

import junit.framework.TestCase;

public class myLibraryTest extends TestCase {

	private Book b1;
	private Book b2;
	private Person p1;
	private Person p2;
	private myLibrary m1;

	public void  testMyLibrary() {
		
		myLibrary l1=new myLibrary("TestLibrary");
		
		assertEquals("TestLibrary", l1.getName());
		assertTrue(l1.books instanceof ArrayList);
		assertTrue(l1.people instanceof ArrayList);
	}
	
	public void  setup() {
		
		b1 = new Book("kitap1");
		b2 = new Book("kitap2");
		
		p1 = new Person();
		p2 = new Person();
		
		p1.setName("Fred");
		
		p2.setName("Elvis");
		
		m1 = new myLibrary("Test");
	}
	
	public void testAddBook() {
		
		setup();
		
		assertEquals(0, m1.getBooks().size());
		
		m1.addBook(b1);
		m1.addBook(b2);
		
		assertEquals(2, m1.getBooks().size());
		assertEquals(0, m1.getBooks().indexOf(b1));
		assertEquals(1, m1.getBooks().indexOf(b2));
		
		m1.removeBook(b1);
		
		assertEquals(1, m1.getBooks().size());
		assertEquals(0, m1.getBooks().indexOf(b2));
		
		m1.removeBook(b2);
		
		assertEquals(0, m1.getBooks().size());
		
	}
	
	public void testAddPerson() {
		
		setup();
		

		assertEquals(0, m1.getPeople().size());
		
		m1.addPerson(p1);
		m1.addPerson(p2);
		
		assertEquals(2, m1.getPeople().size());
		assertEquals(0, m1.getPeople().indexOf(p1));
		assertEquals(1, m1.getPeople().indexOf(p2));
		
		m1.removePerson(p1);
		
		assertEquals(1, m1.getPeople().size());
		assertEquals(0, m1.getPeople().indexOf(p2));
		
		m1.removePerson(p2);
		
		assertEquals(0, m1.getPeople().size());
		
	}
	public void testCheckOut() {
		
		setup();
		
		addItems();
		
		assertTrue("The Book did not check out correctly", m1.checkOut(b1, p1));
		
		assertFalse("The Book was already checked out",m1.checkOut(b1, p1));
		
		assertTrue("Book check in failed",m1.checkIn(b1));
		
		setup();
		
		p1.setMaximumBooks(1);
		
		addItems();
		
		assertTrue("First book did not check out ", m1.checkOut(b2, p1));
		
		assertFalse("Second book should not have checked out", m1.checkOut(b1, p1));
	}

	private void addItems() {
		m1.addBook(b1);
		m1.addBook(b2);
		m1.addPerson(p1);
		m1.addPerson(p2);
	}
	 public void testGetBookForPersons() {
		 
		 setup();
		 
		 addItems();
		 
		 assertEquals(0, m1.getBookForPersons(p1).size());
		 
		 m1.checkOut(b1, p1);
		 ArrayList<Book > testBook=m1.getBookForPersons(p1);
		 assertEquals(1, testBook.size());
		 assertEquals(0, testBook.indexOf(b1));
		 
		 m1.checkOut(b2, p1);
		 testBook=m1.getBookForPersons(p1);
		 assertEquals(2, testBook.size());
		 assertEquals(1, testBook.indexOf(b2));
		
	}
	 
	 public void testGetAvailableBook() {
		 
		 setup();
		 
		 assertEquals(0, m1.getAvailableBooks().size());
		 
		 
		 addItems();
		 
		 assertEquals(2, m1.getAvailableBooks().size());
		 
		 m1.checkOut(b1, p1);
		 		 
		 assertEquals(1, m1.getAvailableBooks().size());
		 m1.checkOut(b2, p1);
		 
		 assertEquals(0, m1.getAvailableBooks().size());
		
	}
	 public void testGetUnvailableBook() {
		 
		 setup();
		 
		 assertEquals(0, m1.getUnavailableBooks().size());
		 
		 
		 addItems();
		 
		 assertEquals(0, m1.getUnavailableBooks().size());
		 
		 m1.checkOut(b1, p1);
		 		 
		 assertEquals(1, m1.getUnavailableBooks().size());
		 m1.checkOut(b2, p1);
		 
		 assertEquals(2, m1.getUnavailableBooks().size());
		
	}
	 public void  testToString() {
		
		 setup();
		 addItems();
		 
		 assertEquals("Test: 2 People and 2 Books", m1.toString());
		 
	}
}
