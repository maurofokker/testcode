package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Assert;
import org.junit.Test;

public class IntersectionPointOfTwoLinkedListTest {

    private IntersectionPointOfTwoLinkedList intersectionPointOfTwoLinkedList = new IntersectionPointOfTwoLinkedList();

    @Test
    public void givenTwoLinkedList_whenScannedAndNodeInCommon_thenReturnIntersectionNode() {

        /**
         * example:
         *  head1 -> 29 -> 23 -> 82 -> 11
         *                                \
         *                                 ` -> 12 -> 27 -> null
         *                                 /
         *  head2 -> 13 -> 4 -------------
         *
         */
        // list 1 nodes
        Node<Integer> node1 = new Node<>(29);
        Node<Integer> node2 = new Node<>(23);
        Node<Integer> node3 = new Node<>(82);
        Node<Integer> node4 = new Node<>(11);
        // list 2 nodes
        Node<Integer> node5 = new Node<>(13);
        Node<Integer> node6 = new Node<>(4);
        // common node
        Node<Integer> node7 = new Node<>(12);
        Node<Integer> node8 = new Node<>(27);
        // list 1
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node7;
        node7.next = node8;
        // list 2
        node5.next = node6;
        node6.next = node7;

        Node<Integer> intersectionNode = intersectionPointOfTwoLinkedList.findIntersection(node1, node5);

        Assert.assertEquals(node7, intersectionNode);
        Assert.assertEquals(new Integer(12), intersectionNode.data);

    }

    @Test
    public void givenTwoLinkedList_whenScannedAndNoNodeInCommon_thenReturnNull() {

        /**
         * example:
         *  head1 -> 29 -> 23 -> 82 -> 11 -> null

         *  head2 -> 13 -> 4 -> null
         *
         */
        // list 1 nodes
        Node<Integer> node1 = new Node<>(29);
        Node<Integer> node2 = new Node<>(23);
        Node<Integer> node3 = new Node<>(82);
        Node<Integer> node4 = new Node<>(11);
        // list 2 nodes
        Node<Integer> node5 = new Node<>(13);
        Node<Integer> node6 = new Node<>(4);

        // list 1
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // list 2
        node5.next = node6;

        Node<Integer> intersectionNode = intersectionPointOfTwoLinkedList.findIntersection(node1, node5);

        Assert.assertEquals(null, intersectionNode);

    }
}
