package stackandqueues;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implement a stack using Queues.
 * <p>
 * Solution #2
 * Runtime Complexity:
 * - push(): Linear, O(n).
 * - pop(): Constant, O(1).
 * Memory Complexity: Linear, O(n).
 */
public class StackUsingQueues2 {

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        StackUsingQueues2 stack = new StackUsingQueues2();
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
        if (queue1.isEmpty()) {
            queue1.add(data);
        } else {
            queue2.add(data);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            swapQueues();
        }
    }

    private boolean isEmpty() {
        return queue1.size() + queue1.size() == 0;
    }

    private int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }
        return queue1.remove();
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
