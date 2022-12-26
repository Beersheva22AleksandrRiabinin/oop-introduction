package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class MyArrays {
	static public <T> void sort (T[] objects, Comparator<T> comparator) {
		int length = objects.length;
		do {
			length--;
		} while (moveMaxAtAnd(objects, length, comparator));		
	}

	private static <T> boolean moveMaxAtAnd(T[] objects, int length, Comparator<T> comparator) {
		boolean res = false;
		for (int i = 0; i < length; i++) {
			if (comparator.compare(objects[i], objects[i + 1]) > 0) {
				swap(objects, i, i + 1);
				res = true;
			}
		}
		return res;
	}

	private static <T> void swap(T[] objects, int i, int j) {
		T tmp = objects[i];
		objects[i] = objects[j];
		objects[j] = tmp;
	}

	public static <T> int binarySearch (T[] array, T key, Comparator<T> comp) {
		int left = 0;
		int right = array.length - 1;
		int middle = right / 2;
		while (left <= right && !array[middle].equals(key)) {
			if (comp.compare(key, array[middle]) < 0) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left > right ? -left - 1 : middle;
	}

	public static <T> T[] filter(T[] array, Predicate<T> predicate) {
		int countPredicate = getCountPredicate(array, predicate);
		T[] res = Arrays.copyOf(array, countPredicate);
		int index = 0;
		for (T element: array) {
			if (predicate.test(element)) {
				res[index++] = element;
			}
		}
		return res;
	}

	private static <T> int getCountPredicate(T[] array, Predicate<T> predicate) {
		int res = 0;
		for (T element: array) {	
			if (predicate.test(element)) {			
				res++;
			}
		}
		return res;
	}
	public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
		
		return filter(array, predicate.negate());
	}

	public static <T> T[] removeRepeated(T[] array) {	
		T[] res = Arrays.copyOf(array, array.length);
		int index = 0;
		while (index < res.length - 1) {
			T[] helper = Arrays.copyOfRange(res, index + 1, res.length);
			if (contains(helper, res[index])) {
				T[] cleanPart = deleteIdentical(helper, res[index]);
				res = Arrays.copyOf(res, index + 1 + cleanPart.length);
				System.arraycopy(cleanPart, 0, res, index + 1, cleanPart.length);
			}
			index++;
		}		
		return res;
	}
	public static <T> T[] deleteIdentical(T[] array, T pattern) {
		return removeIf(array, e -> e.equals(pattern));
	}

	public static <T> boolean contains(T[] array, T pattern) {
		boolean res = false;
		int index = 0;
		while (index < array.length && !res) {
			if (array[index] == null) {
				res = true;
			} else if (array[index].equals(pattern)) {
				res = true;
			}
			index++;
		}			
		return res;
	}

}
