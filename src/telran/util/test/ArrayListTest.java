package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.ArrayList;
import telran.util.List;

class ArrayListTest {
		
	@Test
	void listTest() {
		List<Integer> list = new ArrayList<>(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5); // [1, 2, 3, 4, 5]
		assertEquals(5, list.get(4));
		assertEquals(null, list.get(7));
		
		assertTrue(list.isEmpty());
		
		assertTrue(list.contains(2));
		assertFalse(list.contains(8));
		
		assertEquals(1, list.indexOf(2));
		
		list.add(5);
		list.add(4); // [1, 2, 3, 4, 5, 5, 4]
		assertEquals(5, list.lastIndexOf(5));
		
		list.set(1, 3); // [1, 3, 3, 4, 5, 5, 4]
		
		assertEquals(3, list.get(2));										
				
		assertEquals(7, list.size());
		
		list.remove(2); // [1, 3, 4, 5, 5, 4]
		assertEquals(6, list.size());
		assertEquals(4, list.get(2));				
		
		
		list.remove((Integer) 5); // [1, 3, 4, 4]
		assertEquals(4, list.size());
		assertEquals(4, list.get(2));
		assertEquals(4, list.get(3));
		
			
		list.removeIf(t -> t % 2 == 0); // [1, 3]
		assertEquals(2, list.size());
			
			
		list.add(2, 5); // [1, 3, 5]
		assertEquals(3, list.size());
		
		
		list.add(4, 7); // [1, 3, 5, 7]
		assertEquals(4, list.size());
		
		
		Integer []ar = new Integer[10];
		Integer [] arExpected = {1, 3, 5, 7, null, null, null, null, null, null};
		assertArrayEquals(arExpected, list.toArray(ar));
		
		Integer []ar2 = new Integer[2];
		Integer []ar2expected = {1, 3, 5, 7};
		assertArrayEquals(ar2expected, list.toArray(ar2));		
	}
	
}
