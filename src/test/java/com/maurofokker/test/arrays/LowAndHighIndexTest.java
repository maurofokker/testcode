package com.maurofokker.test.arrays;

import org.junit.Assert;
import org.junit.Test;

public class LowAndHighIndexTest {

    private LowAndHighIndex lowAndHighIndex = new LowAndHighIndex();

    @Test
    public void givenSortedArrayOfIntegers_whenKeyIsGiven_thenReturnLowAndHighIndexInArray() {

        int[] array = {1, 2, 4, 5, 5, 6, 7, 8, 9, 9, 9};

        int key1 = 1;
        int key2 = 5;
        int key3 = 9;

        Assert.assertEquals("Low index for key1 should be 0", 0, lowAndHighIndex.findLowIndex(array, key1));
        Assert.assertEquals("High index for key1 should be 0", 0, lowAndHighIndex.findHighIndex(array, key1));

        Assert.assertEquals("Low index for key2 should be 3", 3, lowAndHighIndex.findLowIndex(array, key2));
        Assert.assertEquals("High index for key2 should be 4", 4, lowAndHighIndex.findHighIndex(array, key2));


        Assert.assertEquals("Low index for key3 should be 8", 8, lowAndHighIndex.findLowIndex(array, key3));
        Assert.assertEquals("High index for key3 should be 10", 10, lowAndHighIndex.findHighIndex(array, key3));

    }
}
