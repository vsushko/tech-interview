package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem
 * <p>
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * [-1, 0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2, 0, 0, 2]
 * ]
 */
public class FourSum {

    public static void main(String[] args) {
        int[] array = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(array, target));
    }

    private static List<List<Integer>> fourSum(int[] array, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = array.length;
        if (array == null || len < 4)
            return res;

        Arrays.sort(array);

        int max = array[len - 1];
        if (4 * array[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = array[i];
            if (i > 0 && z == array[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && array[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }
            threeSumForFourSum(array, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /**
     * Find all possible distinguished three numbers * adding up to the target in sorted array * nums[]
     * between indices low and high. If there * are, add all of them into the ArrayList * fourSumList, using *
     * fourSumList.add(Arrays.asList(z1, the three * numbers))
     */
    private static void threeSumForFourSum(int[] array, int target, int low, int high,
                                           ArrayList<List<Integer>> fourSumList, int z1) {
        if (low + 1 >= high) {
            return;
        }

        int max = array[high];
        if (3 * array[low] > target || 3 * max < target) {
            return;
        }

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = array[i];
            if (i > low && z == array[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && array[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }
            twoSumForFourSum(array, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /**
     * Find all possible distinguished two numbers * adding up to the target in sorted array * nums[]
     * between indices low and high. If there * are, add all of them into the ArrayList * fourSumList, using *
     * fourSumList.add(Arrays.asList(z1, z2, the two * numbers))
     */
    private static void twoSumForFourSum(int[] array, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                         int z1, int z2) {

        if (low >= high) {
            return;
        }
        if (2 * array[low] > target || 2 * array[high] < target) {
            return;
        }

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = array[i] + array[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, array[i], array[j]));

                x = array[i];
                while (++i < j && x == array[i]) ; // avoid duplicate
                x = array[j];
                while (i < --j && x == array[j]) ; // avoid duplicate
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
    }
}