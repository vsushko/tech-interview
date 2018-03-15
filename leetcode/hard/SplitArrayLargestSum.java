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
        System.out.println("splitArray: 18=" + splitArray(array, m));
        array = new int[]{1, 2147483647};
        m = 2;
        System.out.println("splitArray: " + splitArray(array, m));
        array = new int[]{1, 4, 4};
        m = 3;
        System.out.println("splitArray: " + splitArray(array, m));
        m = 1;
        array = new int[]{1, 2, 3, 4, 5};
        System.out.println("splitArray: " + splitArray(array, m));
        m = 5;
        array = new int[]{2,3,1,2,4,3};
        System.out.println("splitArray: " + splitArray(array, m));
        m = 2;
        array = new int[]{2,16,14,15};
        System.out.println("splitArray: " + splitArray(array, m));
    }

    public static int splitArray(int[] A, int blockSize) {

        if (blockSize <= 1) {
            int sum = 0;
            for (int number : A) {
                sum += number;
            }
            return sum;
        }

        for (int number : A) {
            if (number == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        if (A.length == blockSize || A.length -1 == blockSize) {
            int max = A[0];
            for (int index = 1; index < A.length; index++) {
                if (A[index] > max) {
                    max = A[index];
                }
            }
            return max;
        }

        int maxSum = 0;

        for (int i = 0; i < A.length; i += blockSize) {
            int[] array = Arrays.copyOfRange(A, i, Math.min(A.length, i + blockSize));
            System.out.println(Arrays.toString(array));

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
