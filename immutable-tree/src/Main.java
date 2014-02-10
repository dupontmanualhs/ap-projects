
public class Main {
    public static void main(String[] args) {
        ImmutableTree<String> emptyStr = new EmptyTree<String>();
    	ImmutableTree<String> strs = emptyStr.add("m").add("v").add("q").add("l").add("f").add("c").add("k").add("a");
    	System.out.println(strs.toDot());
    }
}
