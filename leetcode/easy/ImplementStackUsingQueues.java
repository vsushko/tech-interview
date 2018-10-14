package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 *
 * @author vsushko
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public ImplementStackUsingQueues() {
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int result = q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return result;
    }

    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
