package stackandqueues;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implement a stack using Queues.
 * <p>
 * Solution #1
 * Runtime Complexity:
 * - push(): Constant, O(1).
 * - pop(): Linear, O(n).
 * Memory Complexity: Linear, O(n).
 * <p>
 * Solution #2
 * Runtime Complexity:
 * - push(): Linear, O(n).
 * - pop(): Constant, O(1).
 * Memory Complexity: Linear, O(n).
 */
public class StackUsingQueues1 {

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        StackUsingQueues1 stack = new StackUsingQueues1();
        stack.push(3);
        stack.printValues();
        stack.push(5);
        stack.printValues();
        stack.push(9);
        stack.printValues();
        stack.pop();
        stack.printValues();
        stack.push(10);
        stack.printValues();
        stack.push(16);
        stack.printValues();
        stack.pop();
        stack.printValues();
    }

    private void push(int data) {
        queue1.add(data);
    }

    private boolean isEmpty() {
        return queue1.size() + queue1.size() == 0;
    }

    private int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int value = queue1.remove();
        swapQueues();

        return value;
    }

    private void swapQueues() {
        Queue<Integer> queue3 = queue1;
        queue1 = queue2;
        queue2 = queue3;
    }

    private void printValues() {
        for (Object s : queue1.toArray()) {
            System.out.print(s.toString() + " ");
        }
        System.out.println();
        for (Object s : queue2.toArray()) {
            System.out.print(s.toString() + " ");
        }
    }
}
