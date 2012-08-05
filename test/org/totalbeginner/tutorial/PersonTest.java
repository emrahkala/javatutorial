package org.totalbeginner.tutorial;

import junit.framework.TestCase;

public class PersonTest extends TestCase {

	public void testPerson() {
		Person p1 = new Person();
		assertEquals("unknown name", p1.getName());
		assertEquals(3, p1.getMaximumBooks());
	}

	public void testSetName() {
		Person p1 = new Person();
		p1.setName("Fred");
		assertEquals("Fred", p1.getName());
	}

	public void testSetMaximumBooks() {
		Person p1 = new Person();
		p1.setMaximumBooks(10);
		assertEquals(10, p1.getMaximumBooks());
	}

	public void testToString() {

		Person p1 = new Person();
		p1.setName("Fred Flintstone");
		p1.setMaximumBooks(7);
		String testString = "Fred Flintstone (7 books)";
		// assertEquals("Fred Flintstone (7 books)", p1.getName()
		// +" ("+p1.getMaximumBooks()+" books)");
		assertEquals(testString, p1.toString());
	}

}
