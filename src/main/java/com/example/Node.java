package com.example;

public class Node<T> {
    private boolean visited;
    Node<T> lower;
    Node<T> right;
    private T value;

    public Node(T _value) {
        this.value = _value;
        this.lower = null;
        this.right = null;
        this.visited = false;
    }

    public Node() {
        this.lower = null;
        this.right = null;
        this.visited = false;
    }

    public T getValue() {
        return value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
