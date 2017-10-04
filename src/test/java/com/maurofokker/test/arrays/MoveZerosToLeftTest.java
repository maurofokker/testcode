package com.maurofokker.test.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mauro on 10/3/17.
 */
public class MoveZerosToLeftTest {

    private MoveZerosToLeft move = new MoveZerosToLeft();

    @Test
    public void givenArrayOfIntegers_whenZeros_thenReturnedArrayWithZerosToLeft() {
        int[] array1 = {2, 4, 0, 1, 23, 0, 11, 0};
        int[] array1Expected = {0, 0, 0, 2, 4, 1, 23, 11};

        int[] array2 = {1, 10, 20, 0, 59, 63, 0, 88, 0, 0};
        int[] array2Expected = {0, 0, 0, 0, 1, 10, 20, 59, 63, 88};

        int[] array3 = {0, 1, 0};
        int[] array3Expected = {0, 0, 1};

        int[] array4 = {0, 0, 0, 0};

        Assert.assertArrayEquals(array1Expected, move.moveZerosToLeft(array1));
        Assert.assertArrayEquals(array2Expected, move.moveZerosToLeft(array2));
        Assert.assertArrayEquals(array3Expected, move.moveZerosToLeft(array3));
        Assert.assertArrayEquals(array4, move.moveZerosToLeft(array4));
    }
}
