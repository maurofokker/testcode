package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;

/**
 * Given head pointer of a linked list, sort it in ascending order using insertion sort.
 *and return new head pointer of the sorted linked list.
 * i.e.
 * Given linkedlist: head -> 29 -> 23 -> 82 -> 11 -> null
 *
 * Sorted linkedlist: head -> 11 -> 23 -> 29 -> 82 -> null
 *
 * Hints
 *  - Maintain two lists i.e. sorted and un-sorted. (is insertion sort)
 */
public class SortedLinkedList {

    /**
     * Runtime complexity O(n^2) while and inner while
     * Memory complexity O(1)
     *
     * While Original list is not empty:
     *   Remove an element (say 'X') from the Original list.
     *   Insert 'X' at correct sorted position in the Sorted list.
     * @param head
     * @return
     */
    public Node<Integer> sort(Node<Integer> head) {

        Node<Integer> sorted = null;
        Node<Integer> curr = head;

        while (curr != null) {

            Node<Integer> temp = curr.next;

            sorted = insertionSort(sorted, curr);

            curr = temp;
        }

        return sorted;
    }

    /**
     * Insertion Sort Algorithm
     *
     * While Original list is not empty:
     *   Remove an element (say 'X') from the Original list.
     *   Insert 'X' at correct sorted position in the Sorted list.
     * @param head
     * @return
     */
    public Node<Integer> insertionSort(Node<Integer> head, Node<Integer> node) {

        if (node == null) {
            return head;
        }

        // insert in first position if node data <= than sorted head data
        if (head == null || node.data <= head.data) {
            node.next = head;
            return node;
        }

        Node<Integer> curr = head;

        // scan sorted list looking for correct sorted position
        while (curr.next != null && (curr.next.data < node.data)) {
            curr = curr.next;
        }

        // insert node
        node.next = curr.next;
        curr.next = node;

        return head;
    }


}
