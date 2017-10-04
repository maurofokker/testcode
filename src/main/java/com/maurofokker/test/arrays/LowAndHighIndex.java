package com.maurofokker.test.arrays;

/**
 * Given a sorted array of integers, return the low and high index of the given key.
 * Return -1 if not found. The array length can be in millions with lots of duplicates.
 * i.e
 *  array = {1, 2, 4, 5, 5, 6, 7, 8, 9, 9, 9}
 *      key: 1 => low index = 0 and high index = 0
 *      key: 5 => low index = 3 and high index = 4
 *      key: 9 => low index = 8 and high index = 10
 * Hint:
 *  -  binary search
 *
 * Solutions:
 * Runtime complexity O(log n) due binary search
 * Memory complexity O(1) constant due to iterative search... if recursive search is done then O(log n) due stack call
 *
 * Note:
 * Linearly scanning the sorted array for low and high indices is highly inefficient since our array size is in millions.
 */
public class LowAndHighIndex {

    /**
     * Algorithm
     *  1 At every step, consider the array between low and high indices
     *  2 Calculate the mid index.
     *  3 If element at mid index is less than the key, low becomes mid + 1 (to move towards start of range)
     *  4 If element at mid is greater or equal to the key, high becomes mid - 1. Index at low remains the same.
     *  5 When low is greater than high, low would be pointing to the first occurrence of the key.
     *  6 If element at low does not match the key, return -1.
     * @param arr
     * @param key
     * @return
     */
    public int findLowIndex( int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;
        int mid = high/2;

        while (low <= high) {

            int mid_elem = arr[mid];

            if (mid_elem < key) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }

            mid = low + (high-low)/2;
        }

        if (arr[low] == key) {
            return low;
        }

        return -1;
    }

    /**
     * Algorithm
     *   slightly modifying the above condition to switch low index to mid+1 when element at mid index is less than equal to the key
     *   and to switch the high index to mid-1 when element at mid is greater than the key
     * @param arr
     * @param key
     * @return
     */
    public int findHighIndex(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;
        int mid = high/2;

        while (low <= high) {

            int mid_elem = arr[mid];

            if (mid_elem <= key) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }

            mid = low + (high-low)/2;
        }

        if (arr[high] == key) {
            return high;
        }

        return -1;
    }

}
