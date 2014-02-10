
public class EmptyTree<T extends Comparable<T>> implements ImmutableTree<T> {
    public EmptyTree() {
    	// default constructor; does nothing
    }
	
	public boolean isEmpty() {
		return true;
	}

	public int size() {
		return 0;
	}

	public ImmutableTree<T> add(T obj) {
		return new NonEmptyTree<T>(obj, this, this);
	}

	public boolean contains(T obj) {
		return false;
	}
	
	public T getMax() {
		throw new UnsupportedOperationException("can't call getMax() on EmptyTree");
	}
	
	public T getMin() {
		throw new UnsupportedOperationException("can't call getMin() on EmptyTree");
	}

	public ImmutableTree<T> remove(T obj) {
		return this;
	}

	public String preOrder() {
		return "";
	}

	public String inOrder() {
		return "";
	}

	public String postOrder() {
		return "";
	}
	
	public String toDot() {
		return "digraph BST {\n    node [shape=point];\n}\n";
	}
	
	public String toDotAux(String me) {
		String parent = me.substring(1);
		return "    " + me + " [shape=point];\n" + "    " + parent + " -> " + me + ";\n";
	}
}
