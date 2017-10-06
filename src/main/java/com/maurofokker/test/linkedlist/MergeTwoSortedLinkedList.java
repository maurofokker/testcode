package com.maurofokker.test.linkedlist;


import com.maurofokker.test.utils.Node;

/**
 * Given two sorted linked lists, merge them such that the resulting linked list is also sorted
 *
 * i.e.
 * LinkedList 1
 *  head1 -> 4 -> 8 -> 15 -> 19 -> null
 *
 * LinkedList 2
 *  head2 -> 7 -> 9 -> 10 -> 16 -> null
 *
 * Merged LinkedList result
 *  head1 -> 4 -> 7 -> 8 -> 9 -> 10 -> 15 -> 16 -> 19 -> null
 *
 * Hint:
 *  Use two iterators to scan both lists.
 */
public class MergeTwoSortedLinkedList {

    /**
     * We maintain a head and tail pointer of the merged linked list. We choose the head of the merged linked list by comparing the first node of both linked lists.
     * For all subsequent nodes in both lists we similarly choose the smaller current node and link it to tail of the merged list
     * and move the current pointer of that list one step forward.
     * We keep doing this while there are some remaining elements in both the lists. If there are still some elements in only one of the lists,
     * we link this remaining list to the tail of the merged list.
     *
     * Initially merged linked list is NULL.
     *
     * Runtime complexity O(m + n)
     * Memory complexity O(1)
     */
    public Node<Integer> mergeSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {

        if (head1 == null && head2 == null)
            return null;
        if (head1 == null && head2 != null)
            return head2;
        if (head1 != null && head2 == null)
            return head1;

        Node<Integer> mergedHead, mergedTail;
        if (head1.data <= head2.data) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }

        mergedTail = mergedHead;

        while (head1 != null && head2 != null) {
            Node<Integer> temp;

            if (head1.data <= head2.data) {
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }

            mergedTail.next = temp;
            mergedTail = temp;
        }

        if (head1 != null) {
            mergedTail.next = head1;
        } else if (head2 != null) {
            mergedTail.next = head2;
        }

        return mergedHead;
    }
}
