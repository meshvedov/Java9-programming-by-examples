import mic.java9.by.example.ch3.SortableCollection;

import java.util.ArrayList;

public class ArrayListSortableCollection implements SortableCollection {
    final private ArrayList actualNames;

    public ArrayListSortableCollection(ArrayList actualNames) {
        this.actualNames = actualNames;
    }

    @Override
    public Object get(int i) {
        return actualNames.get(i);
    }

    @Override
    public int size() {
        return actualNames.size();
    }
}
