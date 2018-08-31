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
        System.out.println("3=" + climbStairsRecBF(3));
        System.out.println("3=" + climbStairsRecMem(3));
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

}
