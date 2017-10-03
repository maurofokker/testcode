package com.maurofokker.test.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RotateArrayTest {

    private RotateArray rotate = new RotateArray();

    @Test
    public void givenArrayOfIntegers_whenRotatedByValue_thenRotationIsOk() {
        int[] array = {-4, 3, 10, 5, 11, 109, -92, 12, 91, 64, 23, 98};

        int[] arrayExpected1 = {3, 10, 5, 11, 109, -92, 12, 91, 64, 23, 98, -4};

        int[] arrayExpected2 = {23, 98, -4, 3, 10, 5, 11, 109, -92, 12, 91, 64};

        Assert.assertTrue(Arrays.equals(arrayExpected1, rotate.rotateArray(array, -1)));
        Assert.assertTrue(Arrays.equals(arrayExpected2, rotate.rotateArray(arrayExpected1, 3)));

        // solution 2
        Assert.assertTrue(Arrays.equals(arrayExpected1, rotate.rotateArraySolution2(array, -1)));
        Assert.assertTrue(Arrays.equals(arrayExpected2, rotate.rotateArraySolution2(arrayExpected1, 3)));
    }

    @Test
    public void givenArrayOfIntegers_whenRotatedByValueSolution2_thenRotationIsOk() {
        int[] array = {-4, 3, 10, 5, 11, 109, -92, 12, 91, 64, 23, 98};

        int[] arrayExpected1 = {3, 10, 5, 11, 109, -92, 12, 91, 64, 23, 98, -4};

        int[] arrayExpected2 = {23, 98, -4, 3, 10, 5, 11, 109, -92, 12, 91, 64};

        Assert.assertTrue(Arrays.equals(arrayExpected1, rotate.rotateArraySolution2(array, -1)));
        Assert.assertTrue(Arrays.equals(arrayExpected2, rotate.rotateArraySolution2(arrayExpected1, 3)));
    }
}
