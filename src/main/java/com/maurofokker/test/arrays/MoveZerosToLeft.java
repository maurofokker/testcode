package com.maurofokker.test.arrays;

/**
 * Created by mauro on 10/3/17.
 *
 * Given an integer array, move all elements containing '0' to the left while maintaining the order
 * of other elements in the array.
 *
 * i.e.
 *  array = {2, 4, 0, 1, 23, 0, 11, 0}
 * move zeros to the left
 *  array = {0, 0, 0, 2, 4, 1, 23, 11}
 *
 * Hint:
 *  - counting
 *  - reader / writer (2 markers)
 *
 * While moving read_index towards the start of the array:
 *   1 if read_index points to '0', skip
 *   2 if read_index points to non-zero, write to write_index and decrement write_index
 */
public class MoveZerosToLeft {

    /**
     * Runtime complexity O(n) linear
     * Memory complexity O(1)
     *
     * While moving read_index towards the start of the array:
     *   1 if read_index points to '0', skip
     *   2 if read_index points to non-zero, write to write_index and decrement
     *
     * @param a array of integers
     * @return array
     */
    public int[] moveZerosToLeft(int[] a) {
        if (a == null) {
            return null;
        }

        int writeIndex = a.length-1;
        int readIndex = a.length-1;

        while(readIndex >= 0) {
            if(a[readIndex] != 0) {
                a[writeIndex] = a[readIndex];
                writeIndex--;
            }

            readIndex--;
        }

        while(writeIndex >= 0) {
            a[writeIndex] = 0;
            writeIndex--;
        }

        return a;
    }

}
