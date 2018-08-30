import java.util.Comparator;

public interface Sort {
    void sort(SortableCollection collection);

    void setSwapper(Swapper swapper);

    void setComparator(Comparator compare);
}
