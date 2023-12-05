package Lab4;

import Lab4.Stacks.SimpleArrayStack;
import Lab4.Stacks.LinkedStack;
import Lab4.Stacks.DynamicArrayStack;
import Lab4.Stacks.Stack;

public class Main {
    public static void main(String[] args) {

        // Testing SimpleArrayStack
        System.out.println("Testing SimpleArrayStack:");
        Stack<Integer> simpleArrayStack = new SimpleArrayStack<>();
        testStack(simpleArrayStack);
        System.out.println("\n");

        // Testing LinkedStack
        System.out.println("Testing LinkedStack:");
        Stack<Integer> linkedStack = new LinkedStack<>();
        testStack(linkedStack);
        System.out.println("\n");

        // Testing DynamicArrayStack
        System.out.println("Testing DynamicArrayStack:");
        Stack<Integer> dynamicArrayStack = new DynamicArrayStack<>();
        testStack(dynamicArrayStack);
    }

    private static void testStack(Stack<Integer> stack) {
        // Push elements
        for (int i = 1; i <= 5; i++) {
            System.out.println("Pushing " + i);
            stack.push(i);
        }

        // Check if stack is empty before poping
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Check if stack is empty before poping
        System.out.println("Is the stack full? " + stack.isFull());

        // Peek & Pop elements
        while (!stack.isEmpty()) {
            System.out.println("Peek top element: " + stack.peek());
            System.out.println("Popping " + stack.pop());
        }

        // Check if stack is empty after poping
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Check if stack is empty after poping
        System.out.println("Is the stack full? " + stack.isFull());
    }
}
