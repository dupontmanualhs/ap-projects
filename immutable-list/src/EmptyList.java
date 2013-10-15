
public class EmptyList<T> implements ImmutableList<T> {
	public boolean isEmpty() {
		return true;
	}

	public T get(int index) {
		throw new IndexOutOfBoundsException("can't call get() on EmptyList");
	}

	public int size() {
		return 0;
	}

	public ImmutableList<T> addAtBeginning(T obj) {
		return new NonEmptyList<T>(obj, this);
	}

	public ImmutableList<T> addAtEnd(T obj) {
		return new NonEmptyList<T>(obj, this);
	}
	
	public ImmutableList<T> add(int index, T obj) {
		if (index == 0) {
			return new NonEmptyList<T>(obj, this);
		} else {
			throw new IndexOutOfBoundsException("can't call add(index, obj) on EmptyList with non-zero index");
		}
	}

	public ImmutableList<T> set(int index, T obj) {
		throw new IndexOutOfBoundsException("can't call set() on EmptyList");
	}

	public ImmutableList<T> remove(int index) {
		throw new IndexOutOfBoundsException("can't call remove() on EmptyList");
	}
	
	public boolean contains(T obj) {
		return false;
	}
	
	public int indexOf(T obj) {
		return -1;
	}
	
	public String toString() {
		return "[]";
	}
}
