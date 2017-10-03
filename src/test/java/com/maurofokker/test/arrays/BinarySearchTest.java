package com.maurofokker.test.arrays;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    private BinarySearch search = new BinarySearch();

    @Test
    public void givenSortedArrayOfIntegers_whenKeyFound_thenReturnPosition() {

        int[] sortedArray = {1, 10, 12, 15, 19, 21, 22, 24, 26, 31, 32,
                            35, 37, 39, 43, 53, 55, 59, 61, 64, 68, 70,
                            71, 78, 79, 80, 81, 84, 88, 89, 91, 94, 96,
                            100, 101, 199, 200, 204, 207, 208, 220, 221};

        // recursive
        Assert.assertEquals(0, search.binary_search_recusive(sortedArray, 1));
        Assert.assertEquals(4, search.binary_search_recusive(sortedArray, 19));
        Assert.assertEquals(10, search.binary_search_recusive(sortedArray, 32));
        Assert.assertEquals(26, search.binary_search_recusive(sortedArray, 81));

        // iterative
        Assert.assertEquals(0, search.binary_search_iterative(sortedArray, 1));
        Assert.assertEquals(4, search.binary_search_iterative(sortedArray, 19));
        Assert.assertEquals(10, search.binary_search_iterative(sortedArray, 32));
        Assert.assertEquals(26, search.binary_search_iterative(sortedArray, 81));

    }

    @Test
    public void givenSortedArrayOfIntegers_whenKeyNotFound_thenReturnMinusOne() {
        int[] sortedArray = {1, 10, 12, 15, 19, 21, 22, 24, 26, 31, 32,
                            71, 78, 79, 80, 81, 84, 88, 89, 91, 94, 96,
                            100, 101, 199, 200, 204, 207, 208, 220, 221};

        // recursive
        Assert.assertEquals(-1, search.binary_search_recusive(sortedArray, 11));
        Assert.assertEquals(-1, search.binary_search_recusive(sortedArray, 13));
        Assert.assertEquals(-1, search.binary_search_recusive(sortedArray, 0));
        Assert.assertEquals(-1, search.binary_search_recusive(sortedArray, 205));

        // iterative
        Assert.assertEquals(-1, search.binary_search_iterative(sortedArray, 11));
        Assert.assertEquals(-1, search.binary_search_iterative(sortedArray, 13));
        Assert.assertEquals(-1, search.binary_search_iterative(sortedArray, 0));
        Assert.assertEquals(-1, search.binary_search_iterative(sortedArray, 205));

    }
}
