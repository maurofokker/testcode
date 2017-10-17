package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;

/**
 * Given head node of a singly linked list and an integer 'n', rotate linked list by 'n'.
 *
 * i.e.
 * given
 *  head -> 1 -> 2 -> 3 -> 4 -> 5 -> null
 *  n=2 or 7
 * return
 *  head -> 4 -> 5 -> 1 -> 2 -> 3 -> null
 *
 *  n=-2
 * return
 *  head -> 3 -> 4 -> 5 -> 1 -> 2 -> null
 *
 */
public class RotateLinkedList {

    public Node<Integer> rotateList(Node<Integer> head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        int len = findLength(head);

        // we need to adjust total number of rotations needed
        n = adjustRotationsNeeded(n, len);

        if (n == 0) {
            return head;
        }

        // Find the start of rotated list. (nth from last)
        // If we have 1,2,3,4,5 where n = 2,
        // 4 is the start of rotated list.
        int rotationsCount = len - n - 1;
        Node<Integer> temp = head;

        while (rotationsCount > 0) {
            rotationsCount--;
            temp = temp.next;
        }

        // After the above loop temp will be pointing
        // to one node prior to rotation point
        Node<Integer> newHead = temp.next;
        // if we hava 1,2,3,4,5 temp will point to 3
        // newHead will point to 4

        // Set new end of list. now we have 1,2,3->null
        temp.next = null;

        // Iterate to the end of list and
        // link that to original head.
        // temp is pointing to 4 in 4,5->null but at the end of scan will point to last node 5
        temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head; // now last node is pointing to firs node in original list 4,5,1,2,3

        return newHead;
    }

    private int findLength(Node<Integer> head) {
        int len = 0;

        while (head != null) {
            ++len;
            head = head.next;
        }

        return len;
    }

    private int adjustRotationsNeeded(int n, int len) {
        // If n is positive then number of rotations performed is from right side
        // and if n is negative then number of rotations performed from left side
        // Let's optimize the number of rotations.
        // Handle case if 'n' is a negative number.
        n = n % len;

        if (n < 0) {
            n = n + len;
        }

        return n;
    }
}
