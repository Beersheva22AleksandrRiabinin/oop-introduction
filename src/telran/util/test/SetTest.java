package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.*;

public class SetTest extends CollectionTest {

	Set<Integer> set;

	@BeforeEach
	void setUp() throws Exception {
		super.setUp();
		set = (Set<Integer>) collection;
	}
	
	@Test
	@Override
	void testAdd() {
		assertTrue(set.add(999));
		assertFalse(set.add(999));
	}
	
	@Test
	@Override
	void testIterator() {
		Integer actual[] = new Integer[numbers.length];
		int index = 0;
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			actual[index++] = it.next();	
		}
		Arrays.sort(numbers);
		Arrays.sort(actual);
		assertArrayEquals(numbers, actual);
		assertThrowsExactly(NoSuchElementException.class, () -> it.next());
	}
	
	@Test
	@Override
	void testRemove() {
		Integer [] expected = {10, 100, -5,  280, 120, 15};
		assertTrue(set.remove((Integer)134));
		Arrays.sort(expected);
		Integer [] actual = set.toArray(empty);
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
		assertFalse(set.remove((Integer)134));
	}	
	
	@Test
	@Override
	void testRemoveIf() {
		Integer []expected = {-5, 15};
		assertTrue(collection.removeIf(n -> n % 2 == 0));
		Integer [] actual = collection.toArray(empty);
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
		assertArrayEquals(expected, collection.toArray(empty));	
		assertFalse(collection.removeIf(n -> n % 2 == 0));
		assertTrue(collection.removeIf(n -> true));
		assertTrue(collection.isEmpty());
	}
	
	@Test
	@Override
	void testToArray() {		
		Arrays.fill(ar, 10);
		assertTrue(ar == collection.toArray(ar));		
		Arrays.sort(ar, 0, collection.size());
		Arrays.sort(numbers);
		for(int i = 0; i < numbers.length; i++) {
			assertEquals(ar[i], numbers[i]);
		}
		for(int i = numbers.length; i < ar.length; i++) {
			assertNull(ar[i]);
		}
		
	}

}
