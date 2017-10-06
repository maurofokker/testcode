package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;

/**
 * Given the head of a singly linked list and 'N', swap the head with Nth node. Return the head of the new linked list.
 *
 * i.e.
 * given likedlist
 *  head -> 7 -> 14 -> 21 -> 28 -> 35 -> 42 -> null
 *  nth node = 4
 *
 * result
 *  head -> 28 -> 14 -> 21 -> 7 -> 35 -> 42 -> null
 *
 *
 */
public class SwapNthNodeWithHead {

    /**
     * Algorithm
     *  1 temp head
     *  2 scan list to node (n-1)
     *  2 swap
     * @param head
     * @param n
     * @return
     */
    public Node<Integer> swapNode(Node<Integer> head, int n) {
        Node<Integer> prev = null;
        Node<Integer> current = head;

        if (head == null) {
            return head;
        }

        if (n == 1) {
            return head; // swap head with head
        }

        for (int count = 1; current != null && count < n; count++) {
            prev = current;
            current = current.next;
            System.out.println("count ->" + count);
        }

        if (current == null) {
            return head;
        }

        // swapp
        prev.next = head;
        Node<Integer> temp = head.next;
        head.next = current.next;
        current.next = temp;

        return current;
    }

}
