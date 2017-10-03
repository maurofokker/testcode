package com.maurofokker.test.arrays;

/**
 * Given a sorted array of integers, return the index of the given key. Return -1 if not found.
 *
 * Binary search is used to find the index of an element in a sorted array. If the element doesn't exist, that can be determined efficiently as well.
 * The algorithm divides the input array by half at every step. After every step, either we have found the index that we are looking for
 * or half of the array can be discarded. Hence, solution can be calculated in O(log n) time.
 *
 * How algorithm works.
 *
 * 1 At every step, consider the array between low and high indices
 * 2 Calculate the mid index.
 * 3 If element at the mid index is the key, return mid.
 * 4 If element at mid is greater than the key, then reduce the array size such that high becomes mid - 1. Index at low remains the same.
 * 5 If element at mid is less than the key, then reduce the array size such that low becomes mid + 1. Index at high remains the same.
 * 6 When low is greater than high, key doesn't exist. Return -1.
 */
public class BinarySearch {


    /**
     * Runtime complexity: O(log n)
     * Memory complexity: O(log n) (because it will consume memory on the stack)
     *
     * @param a sorted array of integers
     * @param key number to search
     * @param low low index in array
     * @param high high index in array
     * @return
     */
    private int binary_search_rec(int[] a, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) / 2);
        if (a[mid] == key) {
            return mid;
        } else if (key < a[mid]) {
            return binary_search_rec(a, key, low, mid - 1);
        } else {
            return binary_search_rec(a, key, mid + 1, high);
        }
    }

    /**
     * Recursive solution
     *
     * @param a sorted array of integers
     * @param key number to search
     * @return
     */
    public int binary_search_recusive(int[] a, int key) {
        return binary_search_rec(a, key, 0, a.length - 1);
    }


    /**
     * Iterative solution
     *
     * Runtime complexity: O(log n)
     * Memory complexity: O(1)
     *
     * @param a sorted array of integers
     * @param key number to search
     * @return
     */
    public int binary_search_iterative(int[] a, int key) {

        int low = 0;
        int high = a.length -1;

        while (low <= high) {

            int mid = low + ((high - low) / 2); // O(1) memory

            if (a[mid] == key) {
                return mid;
            }

            if (key < a[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

}
