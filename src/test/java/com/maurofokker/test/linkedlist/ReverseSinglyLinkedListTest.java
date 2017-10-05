package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Assert;
import org.junit.Test;

public class ReverseSinglyLinkedListTest {

    private ReverseSinlgyLinkedList reverseSinlgyLinkedList = new ReverseSinlgyLinkedList();

    @Test
    public void givenSingleLinkedListOfIntegers_whenPointerToHead_thenReturnPointerToReversedHead() {

        // head -> 7 -> 14 -> 21 -> 28 -> null
        Node<Integer> node1 = new Node<>(7);
        Node<Integer> node2 = new Node<>(14);
        Node<Integer> node3 = new Node<>(21);
        Node<Integer> node4 = new Node<>(28);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node<Integer> reversedHead = reverseSinlgyLinkedList.reverseLinkedListIterative(node1);
        //reversedHead.show();

        Assert.assertEquals(new Integer(28), reversedHead.data);

        // reverse the reversed list with recursive method
        Node<Integer> reversedHeadRecursive = reverseSinlgyLinkedList.reverseLinkedListRecursive(node1);
        Assert.assertEquals(new Integer(7), reversedHeadRecursive.data);
    }
}
