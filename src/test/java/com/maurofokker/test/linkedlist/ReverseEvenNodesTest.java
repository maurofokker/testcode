package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Test;

public class ReverseEvenNodesTest {

    private ReverseEvenNodes reverseEvenNodes = new ReverseEvenNodes();

    @Test
    public void givenLinkedList_whenSorteEvenCall_thenReturnListWithEvenNodesReversed() {
        /**
         * given linkedlist
         *  head -> 29 -> 23 -> 82 -> 11 -> 4 -> 3 -> 21 -> null
         *
         * sorted linkedlist
         *  head -> 29 -> 3-> 82 -> 11 -> 4 -> 23 -> 21 -> null
         */
        Node<Integer> node1 = new Node<>(29);
        Node<Integer> node2 = new Node<>(23);
        Node<Integer> node3 = new Node<>(82);
        Node<Integer> node4 = new Node<>(11);
        Node<Integer> node5 = new Node<>(4);
        Node<Integer> node6 = new Node<>(3);
        Node<Integer> node7 = new Node<>(21);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node<Integer> reverseEvenNodes = this.reverseEvenNodes.reverseEvenNodes(node1);
        int count = 0;
        while (reverseEvenNodes != null) {
            reverseEvenNodes.show();
            reverseEvenNodes = reverseEvenNodes.next;
            count++;
        }
    }
}
