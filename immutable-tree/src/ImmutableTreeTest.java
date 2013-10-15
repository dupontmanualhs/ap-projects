import static org.junit.Assert.*;

import org.junit.Test;


public class ImmutableTreeTest {
	ImmutableTree<Integer> empty = new EmptyTree<Integer>();
	ImmutableTree<Integer> many = empty.add(5).add(2).add(7).add(3).add(1).add(8).add(6);
	
	@Test
	public void isEmpty() {
		assertTrue(empty.isEmpty());
		assertFalse(many.isEmpty());
	}
	
	@Test
	public void inOrder() {
		assertEquals("", empty.preOrder());
		assertEquals("1 2 3 5 6 7 8 ", many.inOrder());
	}
	
	@Test
	public void preOrder() {
		assertEquals("5 2 1 3 7 6 8 ", many.preOrder());
	}
	
	@Test
	public void postOrder() {
		assertEquals("1 3 2 6 8 7 5 ", many.postOrder());
	}
}
