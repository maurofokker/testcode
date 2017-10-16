package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;

/**
 * Given a singly linked list, reverse nodes at even indices  (starting at 1).
 *
 * i.e.
 * given linkedlist
 *  head -> 29 -> 23 -> 82 -> 11 -> 4 -> 3 -> 21 -> null
 *
 * sorted linkedlist
 *  head -> 29 -> 3-> 82 -> 11 -> 4 -> 23 -> 21 -> null
 *
 * Hint:
 *  - use 2 lists
 */
public class ReverseEvenNodes {

    /**
     * Runtime complexity O(n) linear
     * Memory complexity O(1) constant
     *
     * - Scan linkedlist
     * - On even nodes
     *  - push node in head of new linkedlist (evenList)
     *  - remove node in original list
     * - when scan of original list is completed
     *  - merge both lists alternately
     * @param head
     * @return
     */
    public Node<Integer> reverseEvenNodes(Node<Integer> head) {

        // Let's extract even nodes from the existing
        // list and create a new list consisting of
        // even nodes. We will push the even nodes at
        // head since we want them to be in reverse order.

        Node<Integer> curr = head;
        Node<Integer> list_even = null;

        while (curr != null &&
                curr.next != null) {
            Node<Integer> even = curr.next;
            curr.next = even.next;

            // Push at the head of new list.
            even.next = list_even;
            list_even = even;

            curr = curr.next;
        }

        // Now, merge the two lists
        // Original: 1,2,3,4,5
        // Modified original: 1,3,5
        // List_even: 4,2
        // Merged: 1,4,3,2,5

        return mergeAlternating(head, list_even);
    }

    /**
     * Helper function to merge two lists
     * @param list1
     * @param list2
     * @return
     */
    private Node<Integer> mergeAlternating(Node<Integer> list1, Node<Integer> list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        Node<Integer> head = list1;

        while (list1.next != null && list2 != null) {
            Node<Integer> temp = list2;
            list2 = list2.next;

            temp.next = list1.next;
            list1.next = temp;
            list1 = temp.next;
        }

        if (list1.next == null) {
            list1.next = list2;
        }

        return head;
    }


}
