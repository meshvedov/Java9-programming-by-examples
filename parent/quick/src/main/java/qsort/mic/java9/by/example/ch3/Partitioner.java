package qsort.mic.java9.by.example.ch3;

import mic.java9.by.example.ch3.SortableCollection;
import mic.java9.by.example.ch3.Swapper;

import java.util.Comparator;

public class Partitioner<E> {
    private final Comparator<E> comparator;
    private final Swapper swapper;

    public Partitioner(Comparator<E> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
    }

    public int partition(SortableCollection<E> sortable, int start, int end, E pivot) {
        int small = start;
        int large = end;
        while (large > small) {
            while (comparator.compare(sortable.get(small), pivot) < 0 && small < large) {
                small++;
            }
            while (comparator.compare(sortable.get(large), pivot) >= 0 && small < large) {
                large--;
            }
            if (small < large) {
                swapper.swap(small, large);
            }
        }
        return large;
    }
}
