package Lab4.Stacks;

import java.util.NoSuchElementException;

public class DynamicArrayStack<T> implements Stack<T> {
    // array for stack elements
    private T[] stack;
    // integer to keep track of the top of the stack
    private int top;

    public DynamicArrayStack() {
        // The constructor initializes the stack with a default size (here 5)
        // Sets the top to -1, showing that the stack is initially empty.
        stack = (T[]) new Object[5];
        top = -1;
    }

    @Override
    public void push(T element) {
        // Add the element to the top of the stack and increment 'top'
        if (isFull()) {
            // If full, it increases the stack's capacity.
            resize();
        }
        stack[++top] = element;
    }

    private void resize() {
        // Increases stack size
        // Creates a new array, double the size of the current one, and copies all elements from that stack
        // The reference stack is then updated to this new array
        T[] newStack = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
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
        // If the stack is full, which means top is equal to the length of the stack array minus 1
        return top == stack.length - 1;
    }
}

