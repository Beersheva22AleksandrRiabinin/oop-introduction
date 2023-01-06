package telran.util;

public abstract class AbstractCollection<T> implements Collection<T> {
	
	protected int size;
	
	protected boolean isEqual(T element, T pattern) {

		return element == null ? element == pattern : element.equals(pattern);
	}	
	
	public int size() {

		return size;
	}
	
	public boolean isEmpty() {

		return size == 0;
	}

}