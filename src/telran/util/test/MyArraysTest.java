package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.MyArrays;

class MyArraysTest {

	@Test
	void sortTest() {
		String[] strings = {"abcd", "abc", "zz"};
		String[] expected = {"zz", "abc", "abcd"};
//		Integer [] ar = {3, 2, 1};
		MyArrays.sort(strings, new StringsLengthComparator());
		assertArrayEquals(expected, strings);
//		MyArrays.sort(ar, (a, b) -> a - b);
	}
	
	@Test
	void bibarySearchTest() {
		Integer ar[] = { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 20, 40 };
		assertEquals(-14, MyArrays.binarySearch(ar, new NumValueComparator(), 3));
		assertEquals(3, MyArrays.binarySearch(ar, new NumValueComparator(), 2));
		assertEquals(-1, MyArrays.binarySearch(ar, new NumValueComparator(), 0));
		assertEquals(13, MyArrays.binarySearch(ar, new NumValueComparator(), 4));
		assertEquals(0, MyArrays.binarySearch(ar, new NumValueComparator(), 1));
		assertEquals(14, MyArrays.binarySearch(ar, new NumValueComparator(), 20));
		assertEquals(-16, MyArrays.binarySearch(ar, new NumValueComparator(), 25));
		assertEquals(15, MyArrays.binarySearch(ar, new NumValueComparator(), 40));
		assertEquals(-17, MyArrays.binarySearch(ar, new NumValueComparator(), 45));	
	}
	
	@Test 
	void evenOddTest() {
		Integer numbers[] = {13, 2, -8, 47, 100, 10, 7};
		Integer expected[] = {-8, 2, 10, 100, 47, 13, 7};
		MyArrays.sort(numbers, new EvenOddComparator());
		assertArrayEquals(expected, numbers);
	}


}
