package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Assert;
import org.junit.Test;

public class NthNodeFromTheLastTest {

    private NthNodeFromTheLast nthNodeFromTheLast = new NthNodeFromTheLast();

    @Test
    public void givenLinkedListOfIntegers_thenReturnNthNodeFromLast() {

        /**
         * linkedlits
         *  head -> 7 -> 14 -> 21 -> 28 -> 35 -> 42 -> null
         *  find 4th from last (n = 4)
         * Returned node list
         *  head -> 21 -> 28 -> 35 -> 42 -> null
         *
         */
        Node<Integer> node1 = new Node<>(7);
        Node<Integer> node2 = new Node<>(14);
        Node<Integer> node3 = new Node<>(21);
        Node<Integer> node4 = new Node<>(28);
        Node<Integer> node5 = new Node<>(35);
        Node<Integer> node6 = new Node<>(42);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node<Integer> nthFromLast = nthNodeFromTheLast.nthFromLast(node1, 1);
        Node<Integer> temp = nthFromLast;
        int count = 0;
        while (temp != null) {
            temp.show();
            temp = temp.next;
            count++;
        }
        Assert.assertEquals(1, count);
        Assert.assertEquals(new Integer(42), nthFromLast.data);
    }

    @Test
    public void givenLinkedListOfIntegers_whenNRequiredIsGreaterThanListSize_thenReturnNull() {

        /**
         * linkedlits
         *  head -> 7 -> 14 -> 21 -> 28 -> 35 -> 42 -> null
         *  find 4th from last (n = 4)
         * Returned node list
         *  head -> 21 -> 28 -> 35 -> 42 -> null
         *
         */
        Node<Integer> node1 = new Node<>(7);
        Node<Integer> node2 = new Node<>(14);
        Node<Integer> node3 = new Node<>(21);
        Node<Integer> node4 = new Node<>(28);
        Node<Integer> node5 = new Node<>(35);
        Node<Integer> node6 = new Node<>(42);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node<Integer> nthFromLast = nthNodeFromTheLast.nthFromLast(node1, 8);

        Assert.assertNull(nthFromLast);
    }
}
