package org.totalbeginner.tutorial;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	
	public void testBook() {
		
		Book b1=new Book("Great Expectations");
		
		assertEquals("Great Expectations", b1.title);
		assertEquals("Unknown Author", b1.author);
		
	}
	
	public void testGetPerson() {
		 
		 Book b1 =new Book("War And Peace");
		 Person p1 =new Person();
		 p1.setName("Elvis");
		 
		 b1.setPerson(p1);
//		 
//		 Person testPerson=b1.getPerson();
//		 String testName=testPerson.getName();
		 
		 assertEquals("Elvis", b1.getPerson().getName());
		 
		
	}
	
	public void testToString() {
		
		Book b1 =new Book("War And Peace");
		 Person p1 =new Person();
		 p1.setName("Elvis");
		 
		assertEquals("War And Peace by Unknown Author ; Available", b1.toString());
		b1.setPerson(p1);
		
		assertEquals("War And Peace by Unknown Author ; Checked Out by Elvis", b1.toString());
	}

}
