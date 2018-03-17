package dynamicprogramming;


/**
 * Game Scoring: Find number of ways a player can score 'n' runs.
 * <p>
 * Imagine a game (like baseball) where a player can score 1, 2 or 4 runs.
 * Given a score "n", find the total number of ways score "n" can be reached.
 * Solution #1
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Linear, O(n).
 * <p>
 * Solution #2
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant, O(1).
 */
public class GameScoring {

    public static void main(String[] args) {
        System.out.println(scoringOptions(4));
        System.out.println(scoringOptionsDP(4));
    }

    // scoring options are 1,2,4
    private static int scoringOptionsRec(int n, int[] result) {
        if (n < 0) {
            return 0;
        }
        if (result[n] > 0) {
            return result[n];
        }
        // memorize
        result[n] = scoringOptionsRec(n - 1, result) +
                scoringOptionsRec(n - 2, result) +
                scoringOptionsRec(n - 4, result);
        return result[n];
    }

    private static int scoringOptions(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        scoringOptionsRec(n, result);

        return result[n];
    }

    // scoring options are 1,2,4
    private static int scoringOptionsDP(int n) {
        if (n <= 0) {
            return 0;
        }
        // max score is 4. Hence we need to save last 4 ways
        // to calculate the number of ways for a given n
        int[] result = new int[4];

        // save the base case on the last index of the vector
        result[3] = 1;

        for (int i = 1; i <= n; i++) {
            int sum = result[3] + result[2] + result[0];

            // slide left all the results in each iteration
            // result for current i will be save at last index
            result[0] = result[1];
            result[1] = result[2];
            result[2] = result[3];
            result[3] = sum;
        }
        return result[3];
    }
}
