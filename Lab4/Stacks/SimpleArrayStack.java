package Lab4.Stacks;

import java.util.NoSuchElementException;

public class SimpleArrayStack<T> implements Stack<T> {
    // <T> - work with any type of object
    // array for stack elements
    private T[] stack;
    // integer to keep track of the top of the stack
    private int top;
    // maximum size of the stack
    private static final int MAX_SIZE = 5;

    @SuppressWarnings("unchecked")
    public SimpleArrayStack() {
        // Initialize the stack array
        stack = (T[]) new Object[MAX_SIZE];
        // Set 'top' to -1 indicating the stack is empty
        top = -1;
    }

    @Override
    public void push(T element) {
        // Add the element to the top of the stack and increment 'top'
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = element;
    }

    @Override
    public T pop() {
        // Remove and return the top element of the stack and decrement 'top'
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack[top--];
    }

    @Override
    public T peek() {
        // Return the top element of the stack without removing it
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        // The stack is empty if 'top' is -1
        return top == -1;
    }

    @Override
    public boolean isFull() {
        // The stack is full if 'top' is at the last index of the array
        return top == MAX_SIZE - 1;
    }
}

