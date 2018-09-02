package easy;

/**
 * 70. Climbing Stairs
 *
 * @author vsushko
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println("2=" + climbStairsRecBF(2));
        System.out.println("2=" + climbStairsRecMem(2));
        System.out.println("2=" + climbStairsDP(2));
        System.out.println("2=" + climbStairsFN(2));
        System.out.println("2=" + climbingStairs(2));
        System.out.println("2=" + climbStairsFF(2));

        System.out.println("3=" + climbStairsRecBF(3));
        System.out.println("3=" + climbStairsRecMem(3));
        System.out.println("3=" + climbStairsDP(3));
        System.out.println("3=" + climbStairsFN(3));
        System.out.println("3=" + climbingStairs(3));
        System.out.println("3=" + climbStairsFF(3));
    }

    /**
     * Approach 1: Brute Force
     * Time complexity: O(2^n), size of recursion three will be 2^n
     * Space complexity: O(n), the depth of the recursion tree can go up to n
     */
    private static int climbStairsRecBF(int n) {
        return climbStairsRecBF(0, n);
    }

    // i - current step and n defines the destination step
    private static int climbStairsRecBF(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairsRecBF(i + 1, n) + climbStairsRecBF(i + 2, n);
    }

    /**
     * Approach 2: Recursion with memorization
     * Time complexity: O(n), size of recursion tree can go up to n
     * Space complexity: O(n), the depth or recursion tree can go upto n
     */
    private static int climbStairsRecMem(int n) {
        int memo[] = new int[n + 1];
        return climbStairsRecMem(0, n, memo);
    }

    // i - current step and n defines the destination step
    private static int climbStairsRecMem(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairsRecMem(i + 1, n, memo)
                + climbStairsRecMem(i + 2, n, memo);
        return memo[i];
    }

    /**
     * Approach 3: Dynamic Programming
     * Time complexity: O(n), single loop up to n
     * Space complexity: O(n), dp array of size n is used
     */
    private static int climbStairsDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Approach 4: Fibonacci Number
     * Time complexity: O(n), single loop up to n is required to calculate nth fibonacci number
     * Space complexity: O(1), constant space is used
     */
    private static int climbStairsFN(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * Approach 5: Binets Method
     * Time complexity: O(log(n)), traversing on log(n) bits
     * Space complexity: O(1), constant space is used
     */
    private static int climbingStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    private static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];

            }
        }
        return c;
    }

    /**
     * Approach 6: Fibonacci Formula
     * Time complexity: O(log(n)), pow method takes log(n) time
     * Space complexity: O(1), constant space is used
     */
    private static int climbStairsFF(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow(((1 + sqrt5) / 2), n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibN / sqrt5);
    }
}
