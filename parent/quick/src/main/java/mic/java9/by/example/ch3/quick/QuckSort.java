package mic.java9.by.example.ch3.quick;

import mic.java9.by.example.ch3.Sort;
import mic.java9.by.example.ch3.SortableCollection;
import mic.java9.by.example.ch3.Swapper;
import mic.java9.by.example.ch3.qsort.Qsort;

import java.util.Comparator;

public class QuckSort<E> implements Sort<E> {
    private Comparator<E> comparator;
    private Swapper swapper;

    @Override
    public void sort(SortableCollection<E> collection) {
        int n = collection.size();
        Qsort<E> qsort = new Qsort<>(comparator, swapper);
        qsort.qsort(collection, 0, n - 1);
    }

    @Override
    public void setSwapper(Swapper swapper) {
        this.swapper = swapper;
    }

    @Override
    public void setComparator(Comparator<E> compare) {
        this.comparator = compare;
    }
}
