
public class NonEmptyTree<T extends Comparable<T>> implements ImmutableTree<T> {
	private T data;
	private ImmutableTree<T> left;
	private ImmutableTree<T> right;
	
	public NonEmptyTree(T data, ImmutableTree<T> left, ImmutableTree<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public boolean isEmpty() {
		return false;
	}

	public int size() {
		return this.left.size() + 1 + this.right.size();
	}

	public ImmutableTree<T> add(T obj) {
		if (obj.compareTo(data) <= 0) {
			return new NonEmptyTree<T>(data, this.left.add(obj), this.right);
		} else {
			return new NonEmptyTree<T>(data, this.left, this.right.add(obj));
		}
	}

	public boolean contains(T obj) {
		if (obj.equals(this.data)) {
			return true;
		} else if (obj.compareTo(this.data) <= 0) {
			return this.left.contains(obj);
		} else {
			return this.right.contains(obj);
		}
	}
	
	public T getMax() {
		if (this.right.isEmpty()) {
			return this.data;
		} else {
			return this.right.getMax();
		}
	}
	
	public T getMin() {
		if (this.left.isEmpty()) {
			return this.data;
		} else {
			return this.left.getMin();
		}
	}

	public ImmutableTree<T> remove(T obj) {
		if (obj.equals(this.data)) {
			if (this.left.isEmpty()) {
				return this.right;
			} else {
				T newRoot = this.left.getMax();
				return new NonEmptyTree<T>(newRoot, this.left.remove(newRoot), this.right);
			}
		} else if (obj.compareTo(this.data) <= 0) {
			return new NonEmptyTree<T>(this.data, this.left.remove(obj), this.right);
		} else {
			return new NonEmptyTree<T>(this.data, this.left, this.right.remove(obj));
		}
	}

	public String preOrder() {
		return this.data + " " + this.left.preOrder() + this.right.preOrder();
	}

	public String inOrder() {
		return this.left.inOrder() + this.data + " " + this.right.inOrder();
	}

	public String postOrder() {
		return this.left.postOrder() + this.right.postOrder() + this.data + " ";
	}
	
	public String toDot() {
		return "digraph BST {\n" + this.toDotAux("") + "}\n";
	}
	
	public String toDotAux(String me) {
		String node;
		if (me.equals("")) {
			node = "    root [label=\"" + this.data + "\"];";
		} else {
			String parent;
			if (me.length() == 1) {
				parent = "root";
			} else {
				parent = me.substring(1);
			}
			node = "    " + me + " [label=\"" + this.data + "\"];\n" +
		           "    " + parent + " -> " + me + ";\n";
		}
		String leftSubtree = this.left.toDotAux("0" + me);
		String rightSubtree = this.right.toDotAux("1" + me);
		return node + leftSubtree + rightSubtree;
	}
}
