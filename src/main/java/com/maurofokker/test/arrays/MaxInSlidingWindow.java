package com.maurofokker.test.arrays;

import java.util.ArrayDeque;

/**
 * Given a large array of integers and a window of size 'w', find the current maximum in the window as the window slides through the entire array.
 *
 * Algorithm with double linked list
 *
 * 1 Window size is w and array size is n
 * 2 Iterate the first w elements of array; and for each element in the array, do the following:
 *   2.1 remove elements from the tail of window (list) that are smaller than or equal to the current element
 * 3 push current element at the tail of window
 *  - The above step will ensure that the maximum of first w elements is at the head of linked list and it can be printed -
 * 4 Run through remaining elements of the array and for each element do the following:
 *   4.1 remove all elements from the tail of window that are smaller than or equal to the current element
 *   4.2 remove the element at head if its index no longer falls in current window
 *   4.3 push the current element at the tail of window
 *   4.4 current max is at head and can be printed
 *
 *
 * Other solution 1
 *
 * Find maximum by scanning all elements within the window w every time it slides right (complexity O(nw))
 *
 * Other solution 2
 *
 * Use a heap of size w to find max quickly. Every time the window moves one of the elements from the heap that is not present
 * in the windows should be deleted, and it should add a new element. Each operation is O(log w) and the total runtime is O(n log w)
 *
 */
public class MaxInSlidingWindow {

    /**
     * Runtime complexity: O(n) linear
     * Memory complexity: O(w) w: windows size
     * @param array
     * @param window_size
     */
    public int find_max_sliding_window(int[] array, int window_size) {

        if(array.length < window_size) {
            return -1;
        }

        ArrayDeque<Integer> window = new ArrayDeque<Integer>();

        //find out max for the first window
        for(int i=0 ; i<window_size ; i++) {

            while(!window.isEmpty()
                    && array[i] >= array[window.peekLast()] ) {
                window.removeLast();
            }

            window.addLast(i);
        }

        System.out.print(array[window.peekFirst()] + ", ");

        for(int i= window_size; i<array.length; i++) {

            //remove all numbers that are smaller than current number
            //from the tail of queue
            while(!window.isEmpty()
                    && array[i] >= array[window.peekLast()]) {
                window.removeLast();
            }

            //remove first number if it doesn't fall in the window anymore
            if(!window.isEmpty()
                    && window.peekFirst() <= i - window_size) {
                window.removeFirst();
            }

            window.addLast(i);

            System.out.print(array[window.peekFirst()] + ", ");
        }
        System.out.println("window -> " + window);
        return array[window.peekFirst()];

    }
}
