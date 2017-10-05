package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;

/**
 * Given head of a linked list and a key, delete node with this given key from the linked list.
 *
 * i.e.
 *  linkedlist: head -> 7 -> 14 -> 28 -> 21 -> null
 *  key 28
 *
 *  returned linkedlist: head -> 7 -> 14 -> 21 -> null
 *
 * Hints:
 *  - keep track of previous pointer
 */
public class DeleteNodeWithGivenKey {

    public Node<Integer> removeNode(Node<Integer> head, Integer key) {

        if (head == null) {
            return head;
        }
        Node<Integer> current = head;
        if (current.data == key) {
            return current.next;
        }

        while (current.next != null) {
            //current.next.show();
            if (current.next.data == key) {
                System.out.println("Data is equal, node must be deleted");
                /*Node<Integer> temp = current.next;
                current.next.next = null;*/
                current.next = current.next.next;
            }
            current = current.next;
        }

        return head;
    }


    /**
     * Runtime complexity O(n)
     * Memory complexity O(1)
     *
     * Algorithm
     *  First, we have to find the key in the linked list. We'll keep two pointers: current and previous as we iterate the linked list.
     *  If the key is found in the linked list, then current pointer would be pointing to the node containing key to be deleted
     *  and previous should be pointing to the node before the key node. It can be done in a linear scan and we can simply update current
     *  and previous pointers, as we iterate through the linked list.
     ***/
    public static Node<Integer> deleteNode(Node<Integer> head, int key)
    {
        Node<Integer>  prev = null;
        Node<Integer>  current = head;

        while (current != null) {
            if (current.data == key) {
                break;
            }
            prev = current;
            current = current.next;
        }

        // key not found in list
        if (current == null) {
            return head;
        }

        // if node to be deleted is head node
        if (current == head) {
            return current.next;
        }

        // for all other cases
        prev.next = current.next;
        return head;
    }
}
