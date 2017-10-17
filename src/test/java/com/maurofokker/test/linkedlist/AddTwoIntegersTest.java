package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;
import org.junit.Test;

public class AddTwoIntegersTest {

    private AddTwoIntegers addTwoIntegers = new AddTwoIntegers();

    @Test
    public void givenTwoLinkedListOfIntegers_whenAddIsPerformed_thenReturnLinkedListWithResult() {
        /**
         * given linkedlist
         *  head1 -> 1 -> 0 -> 9 -> 9 -> null
         *  head2 -> 7 -> 3 -> 2      -> null
         *
         * result linkedlist
         *  result -> 8 -> 3 -> 1 -> 0 -> 1 -> null
         */
        Node<Integer> head1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(0);
        Node<Integer> node3 = new Node<>(9);
        Node<Integer> node4 = new Node<>(9);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node<Integer> head2 = new Node<>(7);
        Node<Integer> node5 = new Node<>(3);
        Node<Integer> node6 = new Node<>(2);
        head2.next = node5;
        node5.next = node6;

        Node<Integer> result = addTwoIntegers.addIntegersV2(head1, head2);
        int count = 0;
        while (result != null) {
            result.show();
            result = result.next;
            count++;
        }
    }
}
