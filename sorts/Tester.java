import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        String sortType = args[0];
        String listType = args[1];
        int size = Integer.parseInt(args[2]);
        ArrayList<Integer> list = createList(listType, size);
        //System.out.println(list);
        Sort s = new Sort();
        if (sortType.equals("selection")) {
            s.selection(list);
        } else if (sortType.equals("insertion")) {
            s.insertion(list);
        } else if (sortType.equals("heap")) {
            s.heap(list);
        } else if (sortType.equals("merge")) {
            s.merge(list);
        } else if (sortType.equals("quick")) {
            s.quick(list);
        } else if (sortType.equals("quick2")) {
            s.quick2(list);
        }
        //System.out.println(list);
    } 
    
    private static ArrayList<Integer> createList(String type, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        if (type.equals("ascending")) {
            for (int i = 0; i < size; i++) {
                list.add(i);
            }
        } else if (type.equals("descending")) {
            for (int i = size - 1; i >= 0; i--) {
                list.add(i);
            }
        } else if (type.equals("random")) {
            for (int i = 0; i < size; i++) {
                list.add((int) (Math.random() * size * 10));
            }
        }
        return list;
    }
}
