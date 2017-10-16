package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import com.maurofokker.test.utils.Tuple;

/**
 * Given head pointer of a linked sort, sort linked list (in ascending order) using merge sort and return new head pointer of sorted linked list.
 *
 * i.e.
 * given linkedlist *
 *  head -> 29 -> 23 -> 82 -> 11 -> 4 -> 3 -> 21 -> null
 *
 * sorted linkedlist
 *  head -> 3 -> 4-> 11 -> 21 -> 23 -> 29 -> 82 -> null
 *
 * Hint:
 *  - divide and conquer
 */
public class MergeSort {

    /**
     * Solution 1
     *
     * Runtime complexity O(n Log n)
     * Memory complexity O(Log n)
     *
     * The concept of merge sort is very straightforward. In the dividing step, we split our input linked list into two halves
     * and keep doing it until there is a linked list of size 1 or 0. Linked lists of size 1 and 0 are always sorted.
     * In the combining step, we merge sorted lists and keep doing this until we have a completely sorted list.
     * Recurrence relation for this merge sort algorithm will be T(n) = 2T(n/2) + n
     * At each step, we divide our problem into two sub-problems and size of each sub-problem is (n/2) and total cost of
     * combining step (merging sorted lists) is (n).
     * If we solve this recurrence relation, the result will be O(n * log n) which is the time complexity of merge sort.
     */
    public Node<Integer> mergeSort(Node<Integer> head) {

        // No need to sort a single element.
        if (head == null || head.next == null) {
            return head;
        }

        Tuple<Node<Integer>,Node<Integer>> firstSecond = new Tuple<>(null,null);

        // Let's split the list in half, sort the sublists
        // and then merge the sorted lists.
        splitInHalf(head, firstSecond);

        firstSecond.a = mergeSort(firstSecond.a); // divide left side of linked list
        firstSecond.b = mergeSort(firstSecond.b); // divide right side

        return mergeSortedLists(firstSecond.a, firstSecond.b);
    }

    private Node<Integer> mergeSortedLists(Node<Integer> first, Node<Integer> second) {

        if (first == null) {
            return second;
        }
        else if (second == null) {
            return first;
        }

        Node<Integer> newHead;
        if (first.data <= second.data) {
            newHead = first;
            first = first.next;
        }
        else {
            newHead = second;
            second = second.next;
        }

        Node<Integer> newCurrent = newHead;
        while (first != null && second != null) {
            Node<Integer> temp;
            if (first.data <= second.data) {
                temp = first;
                first = first.next;
            } else {
                temp = second;
                second = second.next;
            }

            newCurrent.next = temp;
            newCurrent = temp;
        }

        if (first != null) {
            newCurrent.next = first;
        } else if (second != null) {
            newCurrent.next = second;
        }

        return newHead;
    }

    /**
     * this method splits linked list in two halves by iterating over whole list
     * It returns head pointers of first and 2nd halves of linked lists in firstSecond
     * Head of 1st half is just the head node of linked list
     *
     * Two find middle in linkedlist we use two pointers _fast_ and _slow_
     * _fast_ will move 2 steps each iteration where _slow_ will do 1
     * when _fast_ reach the end of loop then _slow_ will be pointing to middle element of linkedlist
     *  When the fast pointer reaches the end, the slow pointer will be about half way
     *
     * Others solutions:
     *  - iterate over linkedlist and count each node, then divide by 2 and go to that element
     *  - iterate over linkedlist and count each node, use othe pointer mid, and use mid->next when
     *    count is odd
     */
    private void splitInHalf(Node<Integer> head, Tuple<Node<Integer>,Node<Integer>> firstSecond) {

        if (head == null) {
            return;
        }

        // Only one element in the list.
        if (head.next == null) {

            firstSecond.a = head;
            firstSecond.b = null;
        } else {

            // Let's use the classic technique of moving two pointers:
            // 'fast' and 'slow'. 'fast' will move two steps in each
            // iteration where 'slow' will be pointing to middle element
            // at the end of loop.

            Node<Integer> slow, fast;
            slow = head;
            fast = head.next;

            while (fast != null) {

                fast = fast.next;

                if (fast != null) {

                    fast = fast.next;
                    slow = slow.next;
                }
            }

            firstSecond.a = head;
            firstSecond.b = slow.next;

            // Terminate first linked list.
            slow.next = null;
        }
    }


}
