package com.maurofokker.test.linkedlist;


import com.maurofokker.test.utils.Node;

/**
 * Created by mauro on 10/4/17.
 *
 * Given the pointer/reference to the head of a singly linked list, reverse it and return the pointer/reference
 * to the head of reversed linked list.
 *
 * i.e.
 *  original linkedlist: head -> 7 -> 14 -> 21 -> 28 -> null
 *  reversed linkedlist: reversed/head -> 28 -> 21 -> 14 -> 7 -> null
 */
public class ReverseSinlgyLinkedList {

    public Node<Integer> reverseLinkedListIterative(Node<Integer>  head) {
        head.show();
        // no need to reverse if head is null
        // or there is only 1 node.
        if (head == null ||
                head.next == null) {
            return head;
        }

        Node<Integer> remainingListHead = head.next;
        Node<Integer> reversedLinkedListHead = head;

        reversedLinkedListHead.next = null;

        while (remainingListHead != null) {
            remainingListHead.show();
            Node<Integer> temp = remainingListHead;
            remainingListHead = remainingListHead.next;

            temp.next = reversedLinkedListHead;
            reversedLinkedListHead = temp;
        }

        return reversedLinkedListHead;

    }

    public Node<Integer> reverseLinkedListRecursive(Node<Integer> head) {
        //no need to reverse if head is
        //null or there is only 1 node.
        if (head == null ||
                head.next == null) {
            return head;
        }

        Node<Integer> reversedLinkedListHead = reverseLinkedListRecursive(head.next);

        head.next.next = head;
        head.next = null;
        return reversedLinkedListHead;
    }

}
