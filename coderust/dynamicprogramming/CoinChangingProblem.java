package dynamicprogramming;

/**
 * Given coin denominations and the total amount, find out the number​ of ways to make the change.
 * <p>
 * Runtime Complexity: O(m n) where m is number of denominations and n is amount.
 * Memory Complexity: Linear, O(n) where n is the amount.
 */
public class CoinChangingProblem {

    public static void main(String[] args) {
        int[] denominations = new int[]{1, 2, 5};
        int amount = 7;
        System.out.println("Total methods: " + solveCoinChangeDP(denominations, amount));
    }

    private static int solveCoinChangeDP(int[] denominations, int amount) {
        // this solution requires 0(amount) space to store solution
        // until current amount.
        int[] solution = new int[amount + 1];
        solution[0] = 1;

        for (int den : denominations) {
            for (int i = den; i < (amount + 1); i++) {
                solution[i] += solution[i - den];
            }
        }
        return solution[solution.length - 1];
    }

}
