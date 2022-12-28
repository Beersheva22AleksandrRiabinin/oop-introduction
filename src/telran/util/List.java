package telran.util;

public interface List<T> extends Collection<T> {
	
	void add(int index, T element);
	T remove(int index); //в случае неправильного индекса бросается эксепшн
	int indexOf(T pattern); // -1 если нету такого
	int lastIndexOf(T pattern); //говорит писали такое уже
	T get(int index);
	void set(int index, T element); //изменяет элемент под индексом
	

}
