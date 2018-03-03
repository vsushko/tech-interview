package stackandqueues;

import java.util.Stack;

/**
 * Implement a queue using Stacks.
 * <p>
 * Solution #1
 * Runtime Complexity:
 * - enqueue(): Constant, O(1).
 * - dequeue(): Linear, O(n).
 * Memory Complexity: Linear, O(n).
 */
public class QueueUsingStack1 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) throws Exception {
        QueueUsingStack1 stack = new QueueUsingStack1();
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
        stack1.push(data);
    }

    private boolean isEmpty() {
        return stack1.size() + stack2.size() == 0;
    }

    private int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
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
