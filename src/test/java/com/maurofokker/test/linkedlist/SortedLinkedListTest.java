package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Assert;
import org.junit.Test;

public class SortedLinkedListTest {

    private SortedLinkedList sortedLinkedList = new SortedLinkedList();

    @Test
    public void givenUnsortedLinkedList_whenHeadOfLinkedListIsPass_thenReturnHeadSortedLinkedList() {

        /**
         * Given linkedlist: head -> 29 -> 23 -> 82 -> 11 -> null
         *
         * Sorted linkedlist: head -> 11 -> 23 -> 29 -> 82 -> null
         * */
        Node<Integer> node1 = new Node<>(29);
        Node<Integer> node2 = new Node<>(23);
        Node<Integer> node3 = new Node<>(82);
        Node<Integer> node4 = new Node<>(11);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node<Integer> node = sortedLinkedList.sort(node1);
        int count = 0;
        while (node != null) {
            node.show();
            node = node.next;
            count++;
        }

        Assert.assertEquals(4, count);

    }

}

