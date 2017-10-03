package com.maurofokker.test.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, rotate the array by 'N' elements.
 *
 * i.e.
 *   array = {-4, 3, 10, 5, 11, 109, -92, 12, 91, 64, 23, 98}
 * rotate by -1
 *   rotatedArray = {3, 10, 5, 11, 109, -92, 12, 91, 64, 23, 98, -4}
 * rotate by 3
 *   rotatedArray = {23, 98, -4, 3, 10, 5, 11, 109, -92, 12, 91, 64}
 *
 * Hint:
 *  - reverse
 */
public class RotateArray {


    private void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }
    }

    /**
     * Solution 1
     * Runtime complexity: O(n) linear
     * Memory complexity: O(1) constant
     *
     * Algorithm
     *   1 Reverse the elements of the original array.
     *   2 Reverse the elements from 0 -> N-1.
     *   3 Reverse the elements from N -> Length-1.
     *
     * @param arr array of integers
     * @param n times to rotate
     */
    public int[] rotateArray(int[] arr, int n) {

        int len = arr.length;
        // Let's normalize rotations
        // if n > array size or n is negative.
        n = n % len;
        if (n < 0) {
            // calculate the positive rotations needed.
            n = n + len;
        }

        // Let's partition the array based on rotations 'n'.
        // For example: 1, 2, 3, 4, 5 where n = 2.
        // -> 5, 4, 3, 2, 1
        // -> 4, 5, 3, 2, 1
        // -> 4, 5, 1, 2, 3

        reverseArray(arr, 0, len-1);
        reverseArray(arr, 0, n-1);
        reverseArray(arr, n, len-1);

        return arr;
    }


    /**
     * Solution 2
     *
     * Runtime complexity: O(n) linear
     * Memory complexity: O(n)
     *
     * Algorithm
     *   1 Store the last 'N' elements into a temporary array.
     *   2 Shift the original array towards right by 'L-N' places. Here, L is the length of array.
     *   3 Copy the temporary array at the beginning of the original array.
     * @param arr
     * @param n
     */
    public int[] rotateArraySolution2(int[] arr, int n) {
        int len = arr.length;
        // Let's normalize rotations
        // if n > array size or n is negative.
        n = n % len;
        if (n < 0) {
            // calculate the positive rotations needed.
            n = n + len;
        }

        int[] temp = new int[n];

        // copy last N elements of array into temp
        for (int i = 0; i < n; i++) {
            temp[i] = arr[len-n+i]; // memory complexity given by this
        }

        // shift original array
        for (int  i = len-1; i >= n; i--) {
            arr[i] = arr[i-n];
        }

        // copy temp into original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }

}
