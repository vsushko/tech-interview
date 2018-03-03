package stackandqueues;

import java.util.Stack;

/**
 * Implement a queue using Stacks.
 * <p>
 * Solution #2
 * Runtime Complexity:
 * - enqueue(): Linear, O(n).
 * - dequeue(): Constant, O(1).
 * Memory Complexity: Linear, O(n).
 */
public class QueueUsingStack2 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) throws Exception {
        QueueUsingStack2 stack = new QueueUsingStack2();
        stack.enqueue(3);
        stack.printStack();
        stack.enqueue(6);
        stack.printStack();
        stack.dequeue();
        stack.printStack();
        stack.enqueue(10);
        stack.printStack();
        stack.enqueue(8);
        stack.printStack();
        stack.enqueue(4);
        stack.printStack();
        stack.dequeue();
        stack.printStack();
    }

    private void enqueue(int data) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(data);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    private boolean isEmpty() {
        return stack1.size() + stack2.size() == 0;
    }

    private int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        return stack1.pop();
    }

    private void printStack() {
        for (Object o : stack1.toArray()) {
            System.out.print(o.toString() + " ");
        }
        System.out.print("|");
        for (Object o : stack2.toArray()) {
            System.out.print(o.toString() + " ");
        }
        System.out.println();
    }
}
