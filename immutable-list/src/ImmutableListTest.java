import static org.junit.Assert.*;
import org.junit.Test;

public class ImmutableListTest {
	ImmutableList<String> empty = new EmptyList<String>();
	ImmutableList<String> one = new NonEmptyList<String>("a", empty);
	ImmutableList<String> two = new NonEmptyList<String>("a", 
			                        new NonEmptyList<String>("b", empty));
	ImmutableList<String> three = new NonEmptyList<String>("a",
			                           new NonEmptyList<String>("b",
			                        	   new NonEmptyList<String>("c", empty)));
	
	@Test
	public void testToString() {
		assertEquals("[]", empty.toString());
		assertEquals("[a]", one.toString());
		assertEquals("[a, b]", two.toString());
		assertEquals("[a, b, c]", three.toString());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(empty.isEmpty());
		assertFalse(one.isEmpty());
		assertFalse(two.isEmpty());
		assertFalse(three.isEmpty());
	}

	@Test
	public void testGet() {
		try {
			empty.get(0);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
		assertEquals("a", one.get(0));
		assertEquals("a", two.get(0));
		assertEquals("a", three.get(0));
		assertEquals("b", two.get(1));
		assertEquals("b", three.get(1));
		assertEquals("c", three.get(2));
		try {
			three.get(-1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
		try {
			two.get(2);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
	}

	@Test
	public void testSize() {
		assertEquals(0, empty.size());
		assertEquals(1, one.size());
		assertEquals(2, two.size());
		assertEquals(3, three.size());
	}

	@Test
	public void testAddAtBeginning() {
		assertEquals("[x]", empty.addAtBeginning("x").toString());
		assertEquals("[x, a]", one.addAtBeginning("x").toString());
		assertEquals("[y, a, b]", two.addAtBeginning("y").toString());
		assertEquals("[q, a, b, c]", three.addAtBeginning("q").toString());
	}

	@Test
	public void testAddAtEnd() {
		assertEquals("[z]", empty.addAtEnd("z").toString());
		assertEquals("[a, k]", one.addAtEnd("k").toString());
		assertEquals("[a, b, d]", two.addAtEnd("d").toString());
		assertEquals("[a, b, c, four]", three.addAtEnd("four").toString());
	}
	
	@Test
	public void testAdd() {
		try {
			empty.add(2, "x");
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
		assertEquals("[q]", empty.add(0, "q").toString());
		assertEquals("[x, a]", one.add(0, "x").toString());
		assertEquals("[a, x]", one.add(1, "x").toString());
		try {
			one.add(-1, "oops");
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
		assertEquals("[0, a, b, c]", three.add(0, "0").toString());
		assertEquals("[a, 1, b, c]", three.add(1, "1").toString());
		assertEquals("[a, b, 2, c]", three.add(2, "2").toString());
		assertEquals("[a, b, c, 3]", three.add(3, "3").toString());
		try {
			three.add(4, "nope");
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
	}

	@Test
	public void testSet() {
		try {
			empty.set(0, "oops");
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
		assertEquals("[p]", one.set(0, "p").toString());
		assertEquals("[t, b]", two.set(0, "t").toString());
		assertEquals("[a, c]", two.set(1, "c").toString());
		assertEquals("[x, y, z]", three.set(0, "x").set(1, "y").set(2, "z").toString());
		try {
			three.set(3, "whatever");
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
	}

	@Test
	public void testRemove() {
		try {
			empty.remove(0);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
		assertEquals("[]", one.remove(0).toString());
		assertEquals("[a]", two.remove(1).toString());
		assertEquals("[b]", two.remove(0).toString());
		assertEquals("[b, c]", three.remove(0).toString());
		assertEquals("[a, c]", three.remove(1).toString());
		assertEquals("[a, b]", three.remove(2).toString());
		assertEquals("[b]", three.remove(2).remove(0).toString());
	}

}
