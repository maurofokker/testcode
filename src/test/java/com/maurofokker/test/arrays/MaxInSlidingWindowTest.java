package com.maurofokker.test.arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaxInSlidingWindowTest {

    private MaxInSlidingWindow max = new MaxInSlidingWindow();

    @Test
    public void givenArrayOfIntegers_whenWindowSizeIs3_thenMaxReturned() {
        int[] array1 = {-4, -5, 1, -1, 6};
        int[] array2 = {-3, 2, -5, 10, 1, -1, 6, 10, 4};
        int[] array3 = {-4, -1, 9, -1, 3, 4};
        int[] array4 = {21, -5, 1, -1, 6, -4, 14, 19};

        int windowSize = 3;

        Assert.assertEquals(6, max.find_max_sliding_window(array1, windowSize));
        Assert.assertEquals(10, max.find_max_sliding_window(array2, windowSize));
        Assert.assertEquals(4, max.find_max_sliding_window(array3, windowSize));
        Assert.assertEquals(19, max.find_max_sliding_window(array4, windowSize));

    }

    // TODO: change when window size is greater than array to not return -1
}
