
public class NonEmptyList<T> implements ImmutableList<T> {
	private final T first;
	private final ImmutableList<T> rest;
	
	public NonEmptyList(T first, ImmutableList<T> rest) {
		this.first = first;
		this.rest = rest;
	}
	
	public boolean isEmpty() {
		return false;
	}

	public T get(int index) {
		if (index == 0) {
			return this.first;
		} else {
			return this.rest.get(index - 1);
		}
	}

	public int size() {
		return this.rest.size() + 1;
	}

	public ImmutableList<T> addAtBeginning(T obj) {
		return new NonEmptyList<T>(obj, this);
	}

	public ImmutableList<T> addAtEnd(T obj) {
		return new NonEmptyList<T>(this.first, this.rest.addAtEnd(obj));
	}
	
	public ImmutableList<T> add(int index, T obj) {
		if (index == 0) {
			return new NonEmptyList<T>(obj, this);
		} else {
			return new NonEmptyList<T>(this.first, this.rest.add(index - 1, obj));
		}
	}

	public ImmutableList<T> set(int index, T obj) {
		if (index == 0) {
			return new NonEmptyList<T>(obj, this.rest);
		} else {
			return new NonEmptyList<T>(this.first, this.rest.set(index - 1, obj));
		}
	}

	public ImmutableList<T> remove(int index) {
		if (index == 0) {
			return this.rest;
		} else {
			return new NonEmptyList<T>(this.first, this.rest.remove(index - 1));
		}
	}
	
	private String elems() {
		if (this.rest.isEmpty()) {
			return "" + this.first;
		} else {
			return this.first + ", " + ((NonEmptyList<T>) this.rest).elems();
		}
	}
	
	public String toString() {
		return "[" + this.elems() + "]";
	}
}
