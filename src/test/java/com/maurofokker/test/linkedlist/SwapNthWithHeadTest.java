package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Test;

public class SwapNthWithHeadTest {

    private SwapNthNodeWithHead swapNthNodeWithHead = new SwapNthNodeWithHead();

    @Test
    public void givenLinkedListOfArray_whenNthNodeValid_thenReturnSwapList() {

        // head -> 7 -> 14 -> 21 -> 28 -> 35 -> 42 -> 54 -> null
        Node<Integer> node1 = new Node<>(7);
        Node<Integer> node2 = new Node<>(14);
        Node<Integer> node3 = new Node<>(21);
        Node<Integer> node4 = new Node<>(28);
        Node<Integer> node5 = new Node<>(35);
        Node<Integer> node6 = new Node<>(42);
        Node<Integer> node7 = new Node<>(54);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node<Integer> swaped = swapNthNodeWithHead.swapNode(node1, 4);
        // expected: head -> 28 -> 14 -> 21 -> 7 -> 35 -> 42 -> null
        int count = 0;
        while (swaped != null) {
            swaped.show();
            swaped = swaped.next;
            count++;
        }
    }
}
