package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;

/**
 * Given head nodes of two linked lists that may or may not intersect, find out if they intersect and return
 * the point of intersection; return null otherwise.
 *
 * example:
 *  head1 -> 29 -> 23 -> 82 -> 11
 *                                \
 *                                 ` -> 12 -> 27 -> null
 *                                 /
 *  head2 -> 13 -> 4 -------------
 *
 * Solutions:
 * - Cuadratic solution for each node in the first linked list do a linear scan in second linked list. If any node
 *   from first linked list is found in the second linked list (comparing addresses of nodes, not their data), that is
 *   the intersection point. However if none of the nodes from 1st list is found in 2nd list, means there is no intersection point.
 *
 * - A more efficient solution would be to store nodes of the first linked list in a hashset and then go over
 *   the second linked list nodes checking whether any of the nodes exist in the HashSet. This approach has a linear
 *   runtime complexity and linear space complexity.
 *
 * - Better solution to implement O (m + n) size of both linkedlists
 *
 * Runtime complexity O(m + n)
 * Memory complexity O(1)
 *
 */
public class IntersectionPointOfTwoLinkedList {

    /**
     * 1. Find lengths of both linked lists: L1 and L2
     * 2. Calculate difference in length of both linked lists: d = |L1 - L2|
     * 3. Move head pointer of longer list 'd' steps forward
     * 4. Now traverse both lists, comparing nodes until we find a match or reach the end of lists
     */
    public Node<Integer> findIntersection(Node<Integer> node1, Node<Integer> node2) {

        // step 1
        int linkedList1Length = lengthOfLinkedList(node1);
        int linkedList2Length = lengthOfLinkedList(node2);

        Node<Integer> list1 = null;
        Node<Integer> list2 = null;
        int linkedListLengthDifference = 0;

        // step 2
        if (linkedList1Length <= linkedList2Length) {
            linkedListLengthDifference = linkedList2Length - linkedList1Length;
            list1 = node2;
            list2 = node1;
        } else {
            linkedListLengthDifference = linkedList1Length - linkedList2Length;
            list1 = node1;
            list2 = node2;
        }

        // step 3
        while (linkedListLengthDifference > 0) {
            list1 = list1.next;
            linkedListLengthDifference--;
        }

        // step 4
        while (list1 != null) {
            if (list1 == list2)
                return list1;
            list1 = list1.next;
            list2 = list2.next;
        }
        // when no intersection found
        return null;
    }

    private int lengthOfLinkedList(Node<Integer> node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

}
