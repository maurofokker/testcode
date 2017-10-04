package com.maurofokker.test.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mauro on 10/3/17.
 *
 * Given an array of integers and a value, determine if there are any two integers in the array
 * which sum equal to the given value
 * i.e.
 *  array = {5, 7, 1, 2, 8, 4, 3}
 *  given sum 10:
 *      7 + 3 = 10
 *      2 + 8 = 10
 *  given sum 19
 *      there are no 2 values that sum 19
 * Hint:
 *  - hashtable
 *  - sort array
 */
public class SumTwoValues {

    /**
     * Runtime complex O(n) linear
     * Memory complex O(n)
     *
     * Scan whole array once and store visited elements in a hash set.
     *   During scan, for every element 'e' in array, we check if 'val' - 'e' is present in the hash set i.e. 'val' - 'e' is already visited.
     *     If 'val' - 'e' is found in the hash set, it means there is a pair (e, val - e) in array whose sum is equal to the given val.
     *     If we have exhausted all elements in the array and didn't find any such pair, function will return false
     *
     * @param array
     * @param val
     * @return true if there are 2 values that sum val or false otherwise
     */
    public boolean findSumOfTwoValuesSolutionOne(int[] array, int val) {
        Set<Integer> foundValues = new HashSet<>();
        for (int a : array) {
            if (foundValues.contains(val - a)) {
                return true;
            }

            foundValues.add(a);
        }

        return false;
    }


    /**
     * Solution suppose is a sorted array
     * Runtime complex O(n)
     * Memory complex O(1) constant
     *
     * Algorithm
     *
     * // assume 0 is the first index in array
     * // and n is the total number of elements in array
     * left = 0
     * right = n - 1
     * while left is less than right
     *  sum = array[left] + array[right]
     *  if sum == val return true
     *  if sum is less than val
     *    // sum is smaller than value
     *    // means pair can only exist to the
     *    // right of left element, so left element
     *    // should be moved one step next
     *    left = left + 1
     *  else
     *    // sum is greater than value
     *    // means pair can only exist to the
     *    // left of right element, so right element
     *    // should be moved one step previous
     *    right = right - 1
     *
     * @param array
     * @param val
     * @return
     */
    public boolean findSumOfTwoValuesSolutionTwo(int[] array, int val) {

        for (int i = 0, j = array.length - 1; i < j;) {
            int sum = array[i] + array[j];
            if (sum == val) {
                return true;
            }

            if (sum < val) {
                ++i;
            } else {
                --j;
            }
        }

        return false;
    }


}
