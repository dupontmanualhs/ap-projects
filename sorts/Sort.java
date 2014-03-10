import java.util.ArrayList;

public class Sort {
    private <T extends Comparable<T>> void swap(ArrayList<T> list, int n1, int n2) {
        T temp = list.get(n1);
        list.set(n1, list.get(n2));
        list.set(n2, temp);
    }
    
    public <T extends Comparable<T>> void selection(ArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);
        }
    }
    
    public <T extends Comparable<T>> void insertion(ArrayList<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T x = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(x) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, x);
        }
    }
    
    public <T extends Comparable<T>> void heap(ArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            percolateUp(list, i);
        }
        for (int i = list.size() - 1; i > 0; i--) {
            swap(list, 0, i);
            percolateDown(list, 0, i);
        }
    }

    private <T extends Comparable<T>> void percolateUp(ArrayList<T> list, int i) {
        if (i > 0 && list.get((i - 1) / 2).compareTo(list.get(i)) < 0) {
            swap(list, i, (i - 1) / 2);
            percolateUp(list, (i - 1) / 2);
        }
    }
    
    private <T extends Comparable<T>> void percolateDown(ArrayList<T> list, int i, int size) {
        int j = maxChild(list, i, size);
        if (j < size && list.get(j).compareTo(list.get(i)) > 0) {
            swap(list, i, j);
            percolateDown(list, j, size);
        }
    }
    
    private <T extends Comparable<T>> int maxChild(ArrayList<T> list, int i, int size) {
        if (i * 2 + 2 < size && list.get(i * 2 + 1).compareTo(list.get(i * 2 + 2)) < 0) {
            return i * 2 + 2;
        } else {
            return i * 2 + 1;
        }
    }    
    
    public <T extends Comparable<T>> void heap2(ArrayList<T> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            percolateUp2(list, i);
        }
        for (int i = list.size() - 1; i > 0; i--) {
            swap(list, 0, i);
            percolateDown(list, 0, i);
        }
    }
            
    private <T extends Comparable<T>> void percolateUp2(ArrayList<T> list, int i) {
        if (i > 0 && list.get((i - 1) / 2).compareTo(list.get(i)) < 0) {
            swap(list, i, (i - 1) / 2);
        }
    }
    
    public <T extends Comparable<T>> void merge(ArrayList<T> list) {
        merge(list, 0, list.size() - 1);
    }
    
    private <T extends Comparable<T>> void merge(ArrayList<T> list, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge(list, start, mid);
            merge(list, mid + 1, end);
            ArrayList<T> temp = new ArrayList<T>();
            int left = start;
            int right = mid + 1;
            while (left <= mid || right <= end) {
                if (left <= mid && (right > end || list.get(left).compareTo(list.get(right)) < 0)) {
                    temp.add(list.get(left));
                    left++;
                } else {
                    temp.add(list.get(right));
                    right++;
                }
            }
            for (int i = 0; i < temp.size(); i++) {
                list.set(start + i, temp.get(i));
            }
        }
    }
    
    public <T extends Comparable<T>> void quick(ArrayList<T> list) {
        quick(list, 0, list.size() - 1);
    }
    
    private <T extends Comparable<T>> void quick(ArrayList<T> list, int start, int end) {
        if (start < end) {
            T pivot = list.get(end);
            int finalPivotLoc = start;
            for (int i = start; i < end; i++) {
                if (list.get(i).compareTo(pivot) < 0) {
                    swap(list, i, finalPivotLoc);
                    finalPivotLoc++;
                }
            }
            swap(list, end, finalPivotLoc);
            quick(list, start, finalPivotLoc - 1);
            quick(list, finalPivotLoc + 1, end);
        }
    }
    
    public <T extends Comparable<T>> void quick2(ArrayList<T> list) {
        quick2(list, 0, list.size() - 1);
    }
    
    private <T extends Comparable<T>> void quick2(ArrayList<T> list, int start, int end) {
        if (start < end) {
            int pivotLoc = (int) (Math.random() * (end - start + 1) + start);
            swap(list, end, pivotLoc);
            T pivot = list.get(end);
            int finalPivotLoc = start;
            for (int i = start; i < end; i++) {
                if (list.get(i).compareTo(pivot) < 0) {
                    swap(list, i, finalPivotLoc);
                    finalPivotLoc++;
                }
            }
            swap(list, end, finalPivotLoc);
            quick2(list, start, finalPivotLoc - 1);
            quick2(list, finalPivotLoc + 1, end);
        }
    }
            
}
