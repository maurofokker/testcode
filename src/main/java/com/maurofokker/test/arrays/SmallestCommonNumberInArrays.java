package com.maurofokker.test.arrays;

/**
 * Given three integer arrays sorted in ascending order, find the smallest number that is common in all three arrays.
 *
 * array 1
 *  {4, 6, 21, 71 , 91}
 * array 2
 *  {-1, 2, 4, 6, 19}
 * array 3
 *  {1, 3, 5, 6}
 *
 * Common number in arrays 1, 2 and 3 is 6
 *
 * Hints:
 *  - sorted array reduce complexity
 *  - use of 3 pointers starting from index 0 (smallest value in array)
 *
 * If the values of the array indices pointed by the 3 iterators are:
 *  Equal: that's the result. We'll just return the value.
 *  Otherwise, we'll advance the iterator that's pointing to the smallest number among the three.
 * If any of the iterators has reached the end of the array while we haven't found the common number, we'll return -1.
 */
public class SmallestCommonNumberInArrays {

    public int findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {

        int i=0, j=0, k=0;

        while(i < arr1.length &&
                j < arr2.length &&
                    k < arr3.length) {

            // Found the smallest common number
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                System.out.println("i= " + i + " j= " + j + " k= " + k);
                return arr1[i];
            }

            // Let's advance the iterator
            // for the smallest value.

            if(arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
                i++;
            } else if(arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
                j++;
            } else if(arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
                k++;
            }
        }

        return -1;
    }

}
