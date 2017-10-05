package com.maurofokker.test.linkedlist;

import com.maurofokker.test.utils.Node;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mauro on 10/5/17.
 *
 * Remove duplicate nodes from linked list of integers while keeping only the first occurrence of duplicates
 *
 * i.e.
 *  original linkedlist: head -> 7 -> 14 -> 28 -> 28 -> 14 -> 21 -> null
 *  returned linkedlist: head -> 7 -> 14 -> 28 -> 21 -> null
 */
public class RemoveDuplicatesFromLinkedList {

    /**
     * Run complexity O(n)
     * Memory complexity O(n) // store nodes in hashset
     * n = length of linked list
     * add data of first node to a hashset
     * for 2nd to nth node in linked list
     *  if data of 'node' is found is hashset
     *      delete current node
     *  if next node is not null
     *      current is next node
     * @param head
     * @return
     */
    public Node<Integer> removeDuplicates(Node<Integer> head) {
        //head.show();
        if (head == null)
            return head;

        HashSet<Integer> hashSet = new HashSet<>();

        Node<Integer> current = head;
        hashSet.add(current.data);

        while (current.next != null) {
            Node<Integer> temp = current.next;
            //temp.show();current = current.next;

            if (!hashSet.add(temp.data)) {
                System.out.println("set has value "+temp.data);
                current.next = temp.next;
            }
            if (current.next != null)
                current = current.next;

        }
        System.out.println(Arrays.toString(hashSet.toArray()));
        return head;
        // head -> 4 -> 7 -> 4 -> 9 -> 7 -> 11 -> 4 -> null
    }

    /**
     * Run complexity O(n)
     * Memory complexity O(n) // store nodes in hashset
     * n = length of linked list
     * add data of first node to a hashset
     * for 2nd to nth node in linked list
     *  if data of 'node' is found is hashset
     *      delete current node
     *  else
     *      add data of current node to hashset
     * @param head
     * @return
     */
    public Node<Integer> removeDuplicatesSolution2(Node<Integer> head)
    {
        if (head == null) {
            return head;
        }

        // Let's track list values in a hash table.
        HashSet<Integer> duplicatesSet = new HashSet<>();
        Node<Integer> curr = head;
        duplicatesSet.add(curr.data);

        while (curr.next != null) {
            if (!duplicatesSet.contains(curr.next.data)) {
                // Element not found in map, let's add it.
                duplicatesSet.add(curr.next.data);
                curr = curr.next;
            }
            else {
                // Duplicate node found. Let's remove it from the list.
                curr.next = curr.next.next;
            }
        }
        return head;
    }

    /*
    Additional Thoughts:
    The interviewer might ask that we are not allowed to use any extra memory i.e. space complexity of our algorithm should be O(1). We can take these approaches based on the requirements:
        - If we are allowed to change the order of the list, we can just sort the linked list in O(n logn) time. After sorting, all duplicates must be adjacent and can be removed in a linear scan.
        - For each node in the linked list do another scan of the preceding nodes to see if it already exists or not. The time complexity of this algorithm is O(n^2) but it does not require any extra space.
     */
}
