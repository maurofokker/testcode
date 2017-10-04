package com.maurofokker.test.arrays;

/**
 * Created by mauro on 10/3/17.
 *
 * Given an integer array, sort it in ascending order using quicksort
 *
 * Hint:
 *  - divide and conquer
 *
 *
 */
public class QuickSort {

    public int[] quickSort(int[] arr) {
        quickSortRec(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSortRec(int[] arr, int low, int high) {
        if (high > low) {
            int pivotIndex = partition(arr, low, high);

            quickSortRec(arr, low, pivotIndex - 1);
            quickSortRec(arr, pivotIndex + 1, high);
        }
    }

    // Below partition is using Hoare's algorithm.
    private int partition(int[] arr, int low, int high) {
        int pivotValue = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivotValue) i++;
            while (arr[j] > pivotValue) j--;

            if (i < j) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            else {
                break;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivotValue;

        // return the pivot index
        return j;
    }

}
