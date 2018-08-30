package mic.java9.by.example.ch3;

import java.util.Comparator;

public interface Sort<E> {
    void sort(SortableCollection<E> collection);

    void setSwapper(Swapper swapper);

    void setComparator(Comparator<E> compare);
}
