package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;

/**
 * Given a singly linked list and an integer 'k', reverse every 'k' elements. If k <= 1, then input list is unchanged.
 * If k >= n (n is the length of linked list), then reverse the whole linked list.
 * i.e.
 * given
 *  head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
 *  if k=3
 *  reversed k
 *    head -> 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> null
 *  reversed k
 *    head -> 4 -> 3 -> 2 -> 1 -> 6 -> 5 -> null
 *
 * Hint
 *  - reverse first k elements, then move to next k elements, then move to...
 *
 */
public class ReverseKElements {

    /**
     * Runtime complex O(n) linear
     * Memory complexity O(1) constant
     *
     * Work upon a sub-list of size 'k' at a time.
     * Once that sub-list is reversed, we have its head and tail in current_head and current_tail respectively.
     * If it was the first sub-list of size 'k', its head (currentHead) is the head (reversed) of the output linked list.
     * We'll point 'reversed' to currentHead of the first sub-list.
     *   If it is the 2nd or higher sub-list, we'll connect tail of the previous sub-list to head of the current sub-list
     *   i.e. update next pointer of tail of previous sub-list with head pointer of current sub-list to join the two sub-lists.
     *
     * @param head
     * @param k
     * @return
     */
    public Node<Integer> reverseKNodes(Node<Integer> head, int k) {

        // if k is 0 or 1, then list is not changed
        if (k <= 1 || head == null) {
            return head;
        }

        // reversed: it points to the head of the output list
        Node<Integer> reversed = null;
        // prevTail: tail of the already processesed linked list (where sub-lists of size 'k' have been reversed).
        Node<Integer> prevTail = null;

        // process list
        while (head != null && k > 0) {
            // currentHead: head of the sub-list of size 'k' currently being worked upon.
            Node<Integer> currentHead = null;
            // currentTail: tail of the sub-list of size 'k' currently being worked upon.
            Node<Integer> currentTail = head;

            int n = k;
            // process sub-list to reverse node
            while (head != null && n > 0) {
                Node<Integer> temp = head.next; // point to next of head
                head.next = currentHead;
                currentHead = head;

                head = temp;
                n--;
            }

            if (reversed == null) {
                reversed = currentHead;
            }

            if (prevTail != null) {
                prevTail.next = currentHead;
            }
            prevTail = currentTail;
        }

        return reversed;
    }

}
