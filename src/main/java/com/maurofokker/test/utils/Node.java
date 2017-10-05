package com.maurofokker.test.utils;

/**
 * TODO: should use private properties
 * @param <T>
 */
public class Node<T> {
    public T data; // data in node
    public Node<T> next; // next node

    public Node(T data) {
        this.data = data;
    }

    public void show() {
        System.out.print(data + " ");
    }
}
