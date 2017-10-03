package com.maurofokker.test.arrays;

/**
 * Search a given number in a sorted array that has been rotated by some arbitrary number. Return -1 if the number does not exist.
 * i.e
 * array = [1, 2, 4, 6, 8, 11, 14, 17, 21, 32, 36, 40]
 * rotate array 3 times
 * rotatedArray = [32, 36, 40, 1, 2, 4, 6, 8, 11, 14, 17, 21]
 * Search for a given number in rotatedArray
 *
 * Hints:
 *  - Linear search is not an acceptable solution
 *  - Think in a modified binary search
 */
public class RotatedSortedArraySearch {

    /**
     * The solution is essentially binary search with some modifications.At least one half of the array is always sorted.
     * If the number n lies within the sorted half of the array then our problem is basic binary search.
     * Otherwise discard the sorted half and keep examining the unsorted part.
     * Since array is partitioned in half at each step this gives us O(log n) runtime complexity.
     */
    private int binary_search(int[] arr, int st, int end, int key) {
        // assuming all the keys are unique.

        if (st > end) {
            return -1;
        }

        int mid = st + (end-st)/2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[st] < arr[mid] &&
                key < arr[mid] && key >= arr[st]) {
            return binary_search(
                    arr, st, mid-1, key);
        }
        else if (arr[mid] < arr[end] &&
                key > arr[mid] && key <= arr[end]) {
            return binary_search(
                    arr, mid+1, end, key);
        }
        else if (arr[st] > arr[mid]) {
            return binary_search(
                    arr, st, mid-1, key);
        }
        else if (arr[end] < arr[mid]) {
            return binary_search(
                    arr, mid+1, end, key);
        }

        return -1;
    }

    /**
     * Runtime complexity: O(log n) linear
     * Memory complexity: O(log n)  - this could be constant if algorithm is  iterative instead recursive
     *
     * @param arr rotated sorted array (with unique values)
     * @param key value to search for
     * @return
     */
    public int binary_search_rotated(int[] arr, int key) {
        return binary_search(arr, 0, arr.length-1, key);
    }

    // todo: rotate an array by given times

}
