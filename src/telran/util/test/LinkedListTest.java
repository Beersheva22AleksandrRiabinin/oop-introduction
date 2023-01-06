package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.*;

class LinkedListTest extends ListTest{
	@BeforeEach
	@Override 
	void setUp() throws Exception {
		collection = new LinkedList<>();
		super.setUp();
	}
	@Test
	void testHasLoop() {
		assertFalse(list.hasLoop());
		list.setNext(2, 2);
		assertTrue(list.hasLoop());
	}
}