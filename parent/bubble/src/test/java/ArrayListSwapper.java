import mic.java9.by.example.ch3.Swapper;

import java.util.ArrayList;

public class ArrayListSwapper implements Swapper {
    final private ArrayList actualNames;

    public ArrayListSwapper(ArrayList actualNames) {
        this.actualNames = actualNames;
    }

    @Override
    public void swap(int i, int j) {
        Object tmp = actualNames.get(i);
        actualNames.set(i, actualNames.get(j));
        actualNames.set(j, tmp);
    }
}
