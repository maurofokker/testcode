package com.maurofokker.test.utils;

public class SingleLinkedList<T> {

    private Node<T> first;

    public SingleLinkedList() {
        first = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        // in case head point to null
        if (first == null) {
            first = newNode;
        }

        Node<T> current = first; // use temp node to iterate

        // start from head to the end of list
        while (current.next != null) {
            current = current.next;
        }

        // assign the new node to the end
        current.next = newNode;

    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = first; // new->old first
        first = newNode; // first->node
    }

    public Node<T> deleteFirst() throws Exception {
        if (first == null)
            throw new Exception("No nodes in list");
        Node<T> deletedNode = first; // reference to first node
        deletedNode.next = null;    // unlink node it will eligible for gc
        first = first.next;         // first node point to second node
        return deletedNode;         // return deleted node
    }

    public void show() {
        System.out.println("Showing linked list");
        Node<T> temp = first; // beginning of linkedlist
        while (temp != null) {
            temp.show();
            temp = temp.next;
        }
    }
}
