package dynamicprogramming;

/**
 * Given an array, find the contiguous subarray with the largest sum.
 * <p>
 * Kadane's algorithm
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant, O(1).
 */
public class LargestSumSubArray {

    public static void main(String[] args) {
        int[] array = new int[]{-4, 2, -5, 1, 2, 3, 6, -5, 1};
        System.out.println("findMaxSumSubArray: " + findMaxSumSubArray(array));
    }

    private static int findMaxSumSubArray(int[] A) {
        if (A.length < 1) {
            return 0;
        }

        int currMax = A[0];
        int globalMax = A[0];
        for (int i = 1; i < A.length; i++) {
            if (currMax < 0) {
                currMax = A[i];
            } else {
                currMax += A[i];
            }
            if (globalMax < currMax) {
                globalMax = currMax;
            }
        }
        return globalMax;
    }
}
