package miscellaneous;

import java.util.Arrays;

/**
 * Given an array of integers and a value, determine if there are any three integers
 * in the array that sum equal to the given value.
 * <p>
 * Solution #1
 * Runtime Complexity: Cubic, O(n3).
 * Memory Complexity: Constant, O(1).
 * <p>
 * Solution #2
 * Runtime Complexity: O(n2logn).
 * Memory Complexity: Constant, O(1).
 * <p>
 * Solution #3
 * Runtime Complexity: Quadratic, O(n2)
 * Memory Complexity: Constant, O(1)
 */
public class SumOfThreeValues {

    public static void main(String[] args) {
        int[] array = new int[]{3, 7, 1, 2, 8, 4, 5};

        System.out.println("" + findSumOfThreeV1(array, 20));
        System.out.println("" + findSumOfThreeV2(array, 20));
        System.out.println("" + findSumOfThreeV3(array, 20));
    }

    private static boolean findSumOfThreeV1(int[] array, int requiredSum) {
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (i != j && j != k && k != i) {
                        int sum = array[i] + array[j] + array[k];
                        if (sum == requiredSum) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean findSumOfThreeV2(int[] array, int requiredSum) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                // looking for requiredSum = array[i]+array[j]+array[k]
                int remainingSum = requiredSum - array[i] - array[j];
                int k = Arrays.binarySearch(array, remainingSum);
                if (k > 0 && k != i && k != j) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findSumOfThreeV3(int[] array, int requiredSum) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            int remainingSum = requiredSum - array[i];
            if (findSumOfTwo(array, remainingSum, i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean findSumOfTwo(int[] A, int val, int startIndex) {

        for (int i = startIndex, j = A.length - 1; i < j; ) {
            int sum = A[i] + A[j];
            if (sum == val) {
                return true;
            }
            if (sum < val) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }
}
