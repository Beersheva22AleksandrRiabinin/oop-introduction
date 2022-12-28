package telran.util;

import java.util.Arrays;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {
	
	static final int DEFAULT_CAPACITY = 16;
	private T [] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	@Override
	public boolean add(T element) {
		if (size == array.length) {
			reallocate();
		}
		array[size++] = element;
		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);	
	}
	
	@Override
	public boolean remove(T pattern) {
		boolean fl = false;
		for (int i = 0; i < size; i++) {
			if (array[i].equals(pattern)) {
				remove(i);
				i--;
				fl = true;
			}
		}		
		return fl;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {		
		for (int i = 0; i < size; i++) {
			if (predicate.test(array[i])) {
				remove(array[i]);
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		
		return size > -1 ? true : false;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean contains(T pattern) {
		int index = 0;
		while (index < size && !array[index].equals(pattern)) {
			index ++;
		}
		return index < size;
	}

	@Override
	public T[] toArray(T[] ar) {
		if (ar.length >= size) {
			int i = 0;
			for (T elem : array) {
				ar[i++] = elem;
			} 
		} else {
			ar = Arrays.copyOf(ar, size);			
			for (int i = 0; i < size; i++) {
				ar[i] = array[i];
			} 
		}
		return ar;
	}

	@Override
	public void add(int index, T element) {
		array[index] = element;	
		if (index > size) {
			System.arraycopy(array, index, array, size, 1);
			array[index] = null;
		}
		size++;	
	}

	@Override
	public T remove(int index) {		
		if (isValidIndex(index)) {
			System.arraycopy(array, index + 1, array, index, size - index);
			size--;
		}
		return null;
	}

	@Override
	public int indexOf(T pattern) {
		boolean fl = false;
		int index = -1;
		while (!fl) {
			if(array[++index].equals(pattern)) {
				fl = true;
			}
		}
		return index;
	}

	@Override
	public int lastIndexOf(T pattern) {
		boolean fl = false;
		int index = size;
		while (!fl) {
			if(array[--index].equals(pattern)) {
				fl = true;
			}
		}
		return index;
	}

	@Override
	public T get(int index) {
		
		return isValidIndex(index) ? array[index] : null;
	}
	
	private boolean isValidIndex(int index) {
		return index > -1 && index < size;
	}

	@Override
	public void set(int index, T element) {
		if (isValidIndex(index)) {
			array[index] = element;
		}
			
	}

}
