package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;

/**
 * Given head pointers of two linked lists where each linked list represents an integer number (each node is a digit),
 * add them and return the resulting linked list. Here, the first node in a list represents the least significant digit.
 *
 * i.e.
 *  Number 1 = 8101
 *  Number 2 = 305
 *  Sum = 8101 + 305 = 8406
 *
 *  Linkedlist representations
 *  head1 -> 1 -> 0 -> 1 -> 8 -> null
 *  head2 -> 5 -> 0 -> 3      -> null
 * result -> 6 -> 0 -> 4 -> 8 -> null
 *
 *  head1 -> 1 -> 0 -> 9 -> 9 -> null
 *  head2 -> 7 -> 3 -> 2      -> null
 * result -> 8 -> 3 -> 1 -> 0 -> 1 -> null
 *
 * Hint
 *  - use carry
 */
public class AddTwoIntegers {


    public Node<Integer> addIntegers(Node<Integer> head1, Node<Integer> head2) {

        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node<Integer> result = null;
        Node<Integer> current = result;
        int carry = 0;
        int sum = 0;
        while (head1 != null || head2 != null) {

            // if head1 is exhausted
            if (head1 == null) {
                sum = head2.data + carry;
                head2 = head2.next;
            }
            // if head2 is exhausted
            else if (head2 == null) {
                sum = head1.data + carry;
                head1 = head1.next;
            } else {
                sum = head1.data + head2.data + carry;
                head1 = head1.next;
                head2 = head2.next;
            }

            Node<Integer> temp = new Node<>(sum % 10);
            carry = sum / 10;

            if (current != null) {
                current.next = temp;
                current = temp;
            } else {
                current = temp;
                result = temp;
            }

        }
        if (sum >= 10) {
            Node<Integer> temp = new Node<>(carry);
            current.next = temp;
        }

        return result;
    }

    static Node<Integer> addIntegersV2(Node<Integer> integer1, Node<Integer> integer2) {

        Node<Integer> result = null;
        Node<Integer> last = null;
        int carry = 0;

        while (integer1 != null || integer2 != null || carry > 0) {

            int first = (integer1 == null ? 0 : integer1.data);
            int second = (integer2 == null ? 0 : integer2.data);
            int sum = first + second + carry;
            Node<Integer> pNew = new Node<>(sum % 10);
            carry = sum / 10;
            if (result == null) {
                result = pNew;
            } else {
                last.next = pNew;
            }

            last = pNew;
            if (integer1 != null) {
                integer1 = integer1.next;
            }
            if (integer2 != null) {
                integer2 = integer2.next;
            }
        }
        return result;
    }

}
