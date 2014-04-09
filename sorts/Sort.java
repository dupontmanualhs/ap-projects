import java.util.ArrayList;

public class Sort {
    private <T extends Comparable<T>> void swap(ArrayList<T> list, int a, int b) {
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
    
    public <T extends Comparable<T>> void quick(ArrayList<T> list) {
        quick(list, 0, list.size() - 1);
    }
    
    private <T extends Comparable<T>> void quick(ArrayList<T> list, int start, int end) {
        if (start < end) {
            int pivotLoc = start;
            for (int i = start + 1; i <= end; i++) {
                if (list.get(i).compareTo(list.get(pivotLoc)) < 0) {
                    swap(list, i, pivotLoc + 1);
                    swap(list, pivotLoc, pivotLoc + 1);
                    pivotLoc++;
                }
            }
            quick(list, start, pivotLoc - 1);
            quick(list, pivotLoc + 1, end);
        }
    }
    
    public <T extends Comparable<T>> void heap(ArrayList<T> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            percolateUp(list, i);
        }
        for (int i = list.size() - 1; i > 0; i--) {
            swap(list, 0, i);
            percolateDown(list, 0, i);
        }
    }
    
    private <T extends Comparable<T>> void percolateUp(ArrayList<T> list, int i) {
        if (i > 0 && list.get((i - 1) / 2).compareTo(list.get(i)) < 0) {
            swap(list, i, (i - 2) / 2);
            percolateUp(list, (i - 1) / 2);
        }
    }
    
    private <T extends Comparable<T>> void percolateDown(ArrayList<T> list, int elt, int size) {
        int child = maxChild(list, elt, size);
        if (child < size && list.get(child).compareTo(list.get(elt)) > 0) {
            swap(list, elt, child);
            percolateDown(list, child, size);
        }
    }
    
    private <T extends Comparable<T>> int maxChild(ArrayList<T> list, int elt, int size) {
        if (elt * 2 + 2 < size && list.get(elt * 2 + 1).compareTo(list.get(elt * 2 + 2)) < 0) {
            return elt * 2 + 2;
        } else {
            return elt * 2 + 1;
        }
    }
}
                    