package dynamicprogramming;

/**
 * Find the nth fibonacci number.
 * <p>
 * Solution #1
 * Runtime Complexity: Exponential, O(2n).
 * Memory Complexity: Linear, O(n).
 * Memory complexity of recursive solution is O(n) as each recursive call
 * consumes memory on the stack.
 * <p>
 * Solution #2
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant, O(1).
 */
public class FibonacciNumbers {

    public static void main(String[] args) {
        System.out.println("getFibonacciRec = " + getFibonacciRec(4));
        System.out.println("getFibonacci = " + getFibonacci(4));
    }

    private static int getFibonacciRec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return getFibonacciRec(n - 1) + getFibonacciRec(n - 2);
    }

    private static int getFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // fib(n) = fib(n-1) + fib(n-2)

        int n1 = 1; // (n-1)
        int n2 = 0; // (n-2)
        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = n1 + n2;
            n2 = n1;
            n1 = res;

        }
        return res;
    }
}
