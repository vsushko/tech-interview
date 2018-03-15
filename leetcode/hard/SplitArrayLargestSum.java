package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 410. Split Array Largest Sum
 * <p>
 * Given an array which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.
 */
public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] array = new int[]{7, 2, 5, 10, 8};
        int m = 2;
        System.out.println("splitArray: " + splitArray(array, m + 1));
        array = new int[]{1, 2147483647};
        System.out.println("splitArray: " + splitArray(array, 2));
    }

    public static int splitArray(int[] A, int blockSize) {
        if (A.length < 3) {
            return Math.max(A[0], A[1]);
        }
        blockSize+=1;
        int maxSum = 0;

        for (int i = 0; i < A.length; i += blockSize) {
            int[] array = Arrays.copyOfRange(A, i, Math.min(A.length, i + blockSize));

            List<Integer> ints = new ArrayList<>();
            for (int number : array) {
                ints.add(number);
            }

            int listSum = findListSum(ints);
            if (maxSum < listSum) {
                maxSum = listSum;
            }
        }
        return maxSum;
    }

    private static int findListSum(List<Integer> list) {
        int sum = 0;
        for (Integer number : list) {
            sum += number;
        }
        return sum;
    }
}
