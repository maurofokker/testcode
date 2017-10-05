package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromLinkedListTest {

    private RemoveDuplicatesFromLinkedList removeDuplicatesFromLinkedList = new RemoveDuplicatesFromLinkedList();

    @Test
    public void givenLinkedListOfIntegers_whenDuplicatesOnLinkedList_thenReturnLinkedListWithoutDuplicates() {
        // head -> 4 -> 7 -> 4 -> 9 -> 7 -> 11 -> 4 -> null
        Node<Integer> node1 = new Node<>(4);
        Node<Integer> node2 = new Node<>(7);
        Node<Integer> node3 = new Node<>(4);
        Node<Integer> node4 = new Node<>(9);
        Node<Integer> node5 = new Node<>(7);
        Node<Integer> node6 = new Node<>(11);
        Node<Integer> node7 = new Node<>(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node<Integer> withoutDuplicates = removeDuplicatesFromLinkedList.removeDuplicates(node1);

        int count = 0;
        while (withoutDuplicates != null) {
            withoutDuplicates.show();
            withoutDuplicates = withoutDuplicates.next;
            count++;
        }
        Assert.assertEquals(4, count);

    }

}
