package Lab4.Stacks;

import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {
    // <T> - work with any type of object
    private static class Node<T> {
        // A static inner class representing a node in the linked list
        // Each node holds a stack element and a reference to the next node

        // The data element stored in the node
        T element;
        // A reference to the next node in the stack
        Node<T> next;

        // The constructor initializes the node with a data element and a reference to the next node
        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    // Top node of the stack
    private Node<T> top;
    // An integer track the current number of elements in the stack
    private int size;
    // maximum size of the stack
    private static final int MAX_SIZE = 5;

    @Override
    public void push(T element) {
        // A new node is created with the element to be added, and this node is linked to the current top node
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        top = new Node<>(element, top);
        size++;
    }

    @Override
    public T pop() {
        // The element of the top node is saved, top is updated to reference the next node, and the size is decremented
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T element = top.element;
        top = top.next;
        size--;
        return element;
    }

    @Override
    public T peek() {
        // Returns the top element without removing it
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.element;
    }

    @Override
    public boolean isEmpty() {
        // The stack is empty if 'top' is null
        return top == null;
    }

    @Override
    public boolean isFull() {
        return size == MAX_SIZE;
    }
}

