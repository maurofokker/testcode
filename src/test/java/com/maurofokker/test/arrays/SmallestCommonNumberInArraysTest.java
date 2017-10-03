package com.maurofokker.test.arrays;

import org.junit.Assert;
import org.junit.Test;

public class SmallestCommonNumberInArraysTest {

    private SmallestCommonNumberInArrays smallest = new SmallestCommonNumberInArrays();

    @Test
    public void givenThreeSortedArrays_whenExistCommonNumber_thenReturnNumber() {

        int[] array1 = {4, 8, 21, 71 , 91};
        int[] array2 = {-1, 2, 4, 8, 19};
        int[] array3 = {1, 3, 5, 8};

        int[] array4 = {-21, -11, -4, -1, 1, 3, 8, 10, 100, 103, 109, 119};
        int[] array5 = {1, 3, 109, 119};
        int[] array6 = {4, 8, 21, 71 , 91, 93, 99, 100, 103, 109, 111};

        Assert.assertEquals(8, smallest.findLeastCommonNumber(array1, array2, array3));
        Assert.assertEquals(109, smallest.findLeastCommonNumber(array4, array5, array6));
    }

    @Test
    public void givenThreeSortedArrays_whenNotExistCommonNumber_thenReturnMinusOne() {

        int[] array1 = {-21, -11, -4, -1, 1, 3, 8, 10, 100, 103, 109, 119};
        int[] array2 = {1, 3, 109, 1119};
        int[] array3 = {4, 8, 21, 71 , 91, 93, 99, 100, 103, 111, 121};

        Assert.assertEquals(-1, smallest.findLeastCommonNumber(array1, array2, array3));
    }
}
