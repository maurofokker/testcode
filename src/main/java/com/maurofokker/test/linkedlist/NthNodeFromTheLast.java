package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;

/**
 * Given a singly linked list, return nth from last node. Return null if 'n' is out-of-bounds.
 *
 * i.e.
 * linkedlits
 *  head -> 7 -> 14 -> 21 -> 28 -> 35 -> 42 -> null
 *  find 4th from last (n = 4)
 * Returned node list
 *  head -> 21 -> 28 -> 35 -> 42 -> null
 *
 */
public class NthNodeFromTheLast {

    /**
     * Algorithm
     * 1 - use two pointers head and tail (start from head)
     * 2 - move tail pointer the number of nth (n nodes apart of head)
     * 2.1     if pointer is null before nth==0 return out of bound
     * 3 - move two pointers until tail reach null
     * 4 - return head pointer
     * @param head
     * @param n
     */
    public Node<Integer> nthFromLast(Node<Integer> head, int n) {
        if (head == null)
            return null;

        // step 1
        Node<Integer> tail = head;

        // step 2
        while (tail != null && n > 0) {
            tail = tail.next;
            n--;
        }

        // step 2.1
        if (n > 0) {
            return null;
        }

        // step 3
        while (tail != null) {
            tail = tail.next;
            head = head.next;
        }

        // step 4
        return head;
    }

}
