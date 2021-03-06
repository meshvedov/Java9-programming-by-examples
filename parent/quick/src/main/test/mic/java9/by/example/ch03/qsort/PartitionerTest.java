package mic.java9.by.example.ch03.qsort;

import mic.java9.by.example.ch03.support.ArraySwapper;
import mic.java9.by.example.ch03.support.ArrayWrapper;
import mic.java9.by.example.ch3.Swapper;
import org.junit.Assert;
import org.junit.Test;
import mic.java9.by.example.ch3.qsort.Partitioner;

public class PartitionerTest {
    @Test
    public void partitionsIntArray() {
        Integer[] partitionThis = new Integer[]{0, 7, 6, 2};
        Swapper swapper = new ArraySwapper<>(partitionThis);
        Partitioner<Integer> partitioner = new Partitioner<>((a, b) -> a < b ? -1 : a > b ? +1 : 0, swapper);
        final Integer pivot = 6;
        final int cutIndex = partitioner.partition(new ArrayWrapper<>(partitionThis), 0, partitionThis.length - 1, pivot);
        Assert.assertEquals(2, cutIndex);
        final Integer[] expected = new Integer[]{0, 2, 6, 7};
        Assert.assertArrayEquals(expected, partitionThis);
    }
}
