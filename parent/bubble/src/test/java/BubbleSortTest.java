import mic.java9.by.example.ch3.BubbleSort;
import mic.java9.by.example.ch3.Sort;
import mic.java9.by.example.ch3.SortableCollection;
import mic.java9.by.example.ch3.Swapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void canSortingString() {
        ArrayList<String> actualNames = new ArrayList<>(Arrays.asList(
                "Johnson", "Wilson",
                "Wilkinson", "Abraham", "Dagobert"
        ));
        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList(
                "Abraham", "Dagobert",
                "Johnson", "Wilkinson", "Wilson"
        ));
        SortableCollection names = new ArrayListSortableCollection(actualNames);
        Sort sort = new BubbleSort();
        sort.setComparator(new StringComparator());
        sort.setSwapper(new ArrayListSwapper(actualNames));
        sort.sort(names);
        Assert.assertEquals(expectedResult, actualNames);
    }

    @Test(expected = RuntimeException.class)
    public void throwsWhateverComparatorDoes() {
        ArrayList<String> actualNames = new ArrayList<>(Arrays.asList(
                "", "Wilson",
                "Wilkinson", "Abraham", "Dagobert"
        ));
        ((ArrayList) actualNames).set(0, 42);
        SortableCollection names = new ArrayListSortableCollection(actualNames);
        Sort sort = new BubbleSort();
        sort.setComparator((a, b) -> {throw new RuntimeException();});
        final Swapper neverInvoked = null;
        sort.setSwapper(neverInvoked);
        sort.sort(names);
    }
}
