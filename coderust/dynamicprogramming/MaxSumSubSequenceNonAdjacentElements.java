package dynamicprogramming;

/**
 * Find an efficient algorithm to find maximum sum of a subsequence in an array
 * such that no consecutive elements are part of this subsequence.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Linear, O(n)
 */
public class MaxSumSubSequenceNonAdjacentElements {

    public static void main(String[] args) {
        int[] array = new int[]{1, 6, 10, 14, -5, -1, 2, -1, 3};
        System.out.println("findMaxSumNonadjacent: " + findMaxSumNonadjacent(array));
        array = new int[]{1, -1, 6, -4, 2, 2};
        System.out.println("findMaxSumNonadjacent: " + findMaxSumNonadjacent(array));
    }

    private static int findMaxSumNonadjacent(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        if (a.length == 1) {
            return a[0];
        }
        int[] result = new int[a.length];
        result[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            result[i] = Math.max(a[i], result[i - 1]);
            if (i - 2 >= 0) {
                result[i] = Math.max(result[i], a[i] + result[i - 2]);
            }
        }
        return result[a.length - 1];
    }
}
