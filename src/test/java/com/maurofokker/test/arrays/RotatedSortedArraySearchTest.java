package com.maurofokker.test.arrays;

import org.junit.Assert;
import org.junit.Test;

public class RotatedSortedArraySearchTest {

    private RotatedSortedArraySearch search = new RotatedSortedArraySearch();

    @Test
    public void givenRotated3TimesSortedArrayOfIntegers_whenKeyFound_thenReturnPosition() {
        // original sorted array
        //array = {1, 2, 4, 6, 8, 11, 14, 17, 21, 32, 36, 40}
        // rotated sorted array 3 times
        int[] rotatedSortedArray1 = {32, 36, 40, 1, 2, 4, 6, 8, 11, 14, 17, 21};

        // recursive
        Assert.assertEquals(7, search.binary_search_rotated(rotatedSortedArray1, 8));

    }

    @Test
    public void givenRotated3TimesSortedArrayOfIntegers_whenKeyNoFound_thenReturnMinusOne() {
        // original sorted array
        //array = {1, 2, 4, 6, 8, 11, 14, 17, 21, 32, 36, 40}
        // rotated sorted array 3 times
        int[] rotatedSortedArray1 = {32, 36, 40, 1, 2, 4, 6, 8, 11, 14, 17, 21};

        // recursive
        Assert.assertEquals(-1, search.binary_search_rotated(rotatedSortedArray1, 121));

    }
}
