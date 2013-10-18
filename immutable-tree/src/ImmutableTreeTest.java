import static org.junit.Assert.*;

import org.junit.Test;

public class ImmutableTreeTest {
    ImmutableTree<Integer> empty = new EmptyTree<Integer>();
    ImmutableTree<Integer> many = empty.add(5).add(2).add(7).add(3).add(1).add(8).add(6);
    ImmutableTree<String> emptyStr = new EmptyTree<String>();
    ImmutableTree<String> strs = emptyStr.add("m").add("v").add("q").add("l").add("f").add("c").add("k").add("a");
    
    @Test
    public void isEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(many.isEmpty());
        assertTrue(emptyStr.isEmpty());
        assertFalse(strs.isEmpty());
    }
    
    @Test
    public void size() {
        assertEquals(0, empty.size());
        assertEquals(0, emptyStr.size());
        assertEquals(7, many.size());
        assertEquals(8, strs.size());
        assertEquals(1, empty.add(3).size());
        assertEquals(3, emptyStr.add("x").add("y").add("z").size());
    }
    
    @Test
    public void add() {
        // to Empty
        assertEquals("x ", emptyStr.add("x").preOrder());
        // to left side
        ImmutableTree<Integer> t1 = empty.add(3).add(1);
        assertEquals("1 3 ", t1.inOrder());
        assertEquals("3 1 ", t1.preOrder());
        // to right side
        ImmutableTree<Integer> t2 = t1.add(5);
        assertEquals("1 3 5 ", t2.inOrder());
        assertEquals("3 1 5 ", t2.preOrder());
        assertEquals("1 5 3 ", t2.postOrder());
    }
    
    @Test
    public void contains() {
        assertFalse(empty.contains(0));
        assertFalse(emptyStr.contains("a"));
        assertTrue(many.contains(1));
        assertTrue(many.contains(2));
        assertTrue(many.contains(3));
        assertTrue(many.contains(5));
        assertTrue(many.contains(6));
        assertTrue(many.contains(7));
        assertTrue(many.contains(8));
        assertFalse(many.contains(4));
        assertFalse(many.contains(0));
        assertFalse(many.contains(10));
        assertTrue(strs.contains("a"));
        assertTrue(strs.contains("c"));
        assertTrue(strs.contains("f"));
        assertTrue(strs.contains("k"));
        assertTrue(strs.contains("l"));
        assertTrue(strs.contains("m"));
        assertTrue(strs.contains("q"));
        assertTrue(strs.contains("v"));
        assertFalse(strs.contains(""));
        assertFalse(strs.contains("b"));
        assertFalse(strs.contains("z"));
        assertFalse(strs.contains("o"));
        assertFalse(strs.contains("r"));
        assertFalse(strs.contains("1"));
    }
    
    @Test
    public void getMax() {
        try {
            empty.getMax();
            fail("should have thrown UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            //pass
        }
        try {
            emptyStr.getMax();
            fail("should have throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            //pass
        }
        assertEquals(new Integer(8), many.getMax());
        assertEquals("v", strs.getMax());
    }
    
    @Test
    public void getMin() {
        try {
            empty.getMin();
            fail("should have thrown UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            //pass
        }
        try {
            emptyStr.getMin();
            fail("should have throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            //pass
        }
        assertEquals(new Integer(1), many.getMin());
        assertEquals("a", strs.getMin());
    }
    
    @Test
    public void remove() {
        ImmutableTree<Integer> t1 = empty.remove(0);
        assertEquals(0, t1.size());
        assertEquals("", t1.inOrder());
        ImmutableTree<String> t2 = emptyStr.add("xyz").remove("xyz");
        assertEquals(0, t2.size());
        assertEquals("", t2.inOrder());
        ImmutableTree<Integer> t3 = many.remove(5).remove(6);
        assertEquals(5, t3.size());
        assertEquals("3 2 1 7 8 ", t3.preOrder());
        assertEquals("1 2 3 7 8 ", t3.inOrder());
        ImmutableTree<Integer> t4 = t3.remove(7);
        assertEquals(4, t4.size());
        assertEquals("3 2 1 8 ", t4.preOrder());
        assertEquals("1 2 3 8 ", t4.inOrder());
    }

    @Test
    public void inOrder() {
        assertEquals("", empty.inOrder());
        assertEquals("", emptyStr.inOrder());
        assertEquals("1 2 3 5 6 7 8 ", many.inOrder());
        assertEquals("a c f k l m q v ", strs.inOrder());
    }
    
    @Test
    public void preOrder() {
        assertEquals("", empty.preOrder());
        assertEquals("", emptyStr.preOrder());
        assertEquals("5 2 1 3 7 6 8 ", many.preOrder());
        assertEquals("m l f c a k v q ", strs.preOrder());
    }
    
    @Test
    public void postOrder() {
        assertEquals("", empty.postOrder());
        assertEquals("", emptyStr.postOrder());
        assertEquals("1 3 2 6 8 7 5 ", many.postOrder());
        assertEquals("a c k f l q v m ", strs.postOrder());
    }
}
