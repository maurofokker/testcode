package com.maurofokker.test.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mauro on 10/3/17.
 */
public class SumTwoValuesTest {

    private SumTwoValues sumTwoValues = new SumTwoValues();

    @Test
    public void givenArrayOfIntegers_whenValue10required_thenSumIsFound() {
        int[] array1 = {5, 7, 1, 2, 8, 4, 3};

        Assert.assertTrue(sumTwoValues.findSumOfTwoValuesSolutionOne(array1, 10));
    }

    @Test
    public void givenArrayOfIntegers_whenValue19required_thenSumIsNotFound() {
        int[] array1 = {5, 7, 1, 2, 8, 4, 3};

        Assert.assertFalse(sumTwoValues.findSumOfTwoValuesSolutionOne(array1, 19));
    }

    @Test
    public void givenSortedArrayOfIntegers_whenValue10required_thenSumIsFound() {
        int[] array1 = {1, 2, 3, 4, 5, 7, 8};

        Assert.assertTrue(sumTwoValues.findSumOfTwoValuesSolutionTwo(array1, 10));
    }

    @Test
    public void givenSortedArrayOfIntegers_whenValue19required_thenSumIsNotFound() {
        int[] array1 = {1, 2, 3, 4, 5, 7, 8};

        Assert.assertFalse(sumTwoValues.findSumOfTwoValuesSolutionTwo(array1, 19));
    }
}
