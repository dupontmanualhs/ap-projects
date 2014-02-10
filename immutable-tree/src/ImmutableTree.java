
public interface ImmutableTree<T extends Comparable<T>> {
	boolean isEmpty();
	int size();
	
	ImmutableTree<T> add(T obj);
	
	boolean contains(T obj);
	T getMax();
	T getMin();
	
	ImmutableTree<T> remove(T obj);
	
	String preOrder();
	String inOrder();
	String postOrder();
	
	String toDot();
	String toDotAux(String code);
}
