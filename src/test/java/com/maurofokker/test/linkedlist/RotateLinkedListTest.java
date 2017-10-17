package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Test;

public class RotateLinkedListTest {

    RotateLinkedList rotateLinkedList = new RotateLinkedList();

    @Test
    public void givenLinkedList_whenNumberOfRotationsAssinged_thenReturnHeadOfRotatedList(){
        /**
         * given linkedlist
         *  head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
         *  n=2
         * sorted linkedlist
         *  head -> 6 -> 7 -> 1 -> 2 -> 3 -> 4 -> 5 -> null
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

        Node<Integer> rotated = rotateLinkedList.rotateList(node1, 2);
        int count = 0;
        while (rotated != null) {
            rotated.show();
            rotated = rotated.next;
            count++;
        }
    }
}
