package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Test;

public class ReverseKElementsTest {

    private ReverseKElements reverseKElements = new ReverseKElements();

    @Test
    public void givenLinkedList_when5elementIsAssigned_thenReturnHeadOfReversedKElements() {
        /**
         * given linkedlist
         *  head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
         *  k=5
         * sorted linkedlist
         *  head -> 5 -> 4 -> 3 -> 2 -> 1 -> 7 -> 6 -> null
         */
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node<Integer> reversed = reverseKElements.reverseKNodes(node1, 5);
        int count = 0;
        while (reversed != null) {
            reversed.show();
            reversed = reversed.next;
            count++;
        }
    }
}
