package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Test;

public class MergeTwoSortedLinkedListTest {

    private MergeTwoSortedLinkedList mergeTwoSortedLinkedList = new MergeTwoSortedLinkedList();

    @Test
    public void givenTwoSortedLinkedList_thenReturnMergedSortedLinkedList() {

        /**
         * LinkedList 1
         *  head1 -> 4 -> 8 -> 15 -> 19 -> null
         *
         * LinkedList 2
         *  head2 -> 7 -> 9 -> 10 -> 16 -> null
         */
        Node<Integer> node1 = new Node<>(4);
        Node<Integer> node2 = new Node<>(8);
        Node<Integer> node3 = new Node<>(15);
        Node<Integer> node4 = new Node<>(19);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node<Integer> node5 = new Node<>(7);
        Node<Integer> node6 = new Node<>(9);
        Node<Integer> node7 = new Node<>(10);
        Node<Integer> node8 = new Node<>(16);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        Node<Integer> merged = mergeTwoSortedLinkedList.mergeSortedLinkedLists(node1, node5);
        //  head1 -> 4 -> 7 -> 8 -> 9 -> 10 -> 15 -> 16 -> 19 -> null
        int count = 0;
        while (merged != null) {
            merged.show();
            merged = merged.next;
            count++;
        }

    }
}
