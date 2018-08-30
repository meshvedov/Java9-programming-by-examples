package mic.java9.by.example.ch3;

import mic.java9.by.example.ch3.Sort;
import mic.java9.by.example.ch3.SortableCollection;
import mic.java9.by.example.ch3.Swapper;

import java.util.Comparator;

public class BubbleSort<E> implements Sort<E> {
    private Swapper swapper = null;

    @Override
    public void setSwapper(Swapper swapper) {
        this.swapper = swapper;
    }

    private Comparator<E> comparator = null;

    @Override
    public void setComparator(Comparator<E> compare) {
        this.comparator = compare;
    }

    @Override
    public void sort(SortableCollection<E> collection) {
        int n = collection.size();
        while (n > 1) {
            for (int j = 0; j < n - 1; j++) {
                if (comparator.compare(collection.get(j), collection.get(j + 1)) > 0) {
                    swapper.swap(j, j + 1);
                }
            }
            n--;
        }
    }
}
