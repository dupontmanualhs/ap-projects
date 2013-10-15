
public interface ImmutableList<T> {
	boolean isEmpty();
	T get(int index);
	int size();
	
	ImmutableList<T> addAtBeginning(T obj);
	ImmutableList<T> addAtEnd(T obj);
	ImmutableList<T> add(int index, T obj);
	
	ImmutableList<T> set(int index, T obj);
	ImmutableList<T> remove(int index);
	boolean contains(T obj);
	int indexOf(T obj);
}
