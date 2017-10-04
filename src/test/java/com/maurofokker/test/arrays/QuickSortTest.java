package com.maurofokker.test.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mauro on 10/3/17.
 */
public class QuickSortTest {

    private QuickSort quickSort = new QuickSort();

    @Test
    public void givenArrayOfIntegers_whenApplyQuickSort_thenArraySorted() {

        int[] array1 = {55, 23, 26, 2, 25};
        int[] expected1 = {2, 23, 25, 26, 55};

        int[] array2 = {55, 23, 26, 2, 18, 78, 23, 8, 2, 3};
        int[] expected2 = {2, 2, 3, 8, 18, 23, 23, 26, 55, 78};

        Assert.assertArrayEquals(expected1, quickSort.quickSort(array1));
        Assert.assertArrayEquals(expected2, quickSort.quickSort(array2));

    }
}
