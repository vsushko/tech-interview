package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * <p>
 * https://leetcode.com/problems/two-sum/description/
 *
 * @author vsushko
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 4;
        System.out.println("1: " + Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println("1: " + Arrays.toString(twoSumTwoPassHashTable(nums, target)));
        System.out.println("1: " + Arrays.toString(onePassHashTable(nums, target)));
        System.out.println();

        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println("2: " + Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println("2: " + Arrays.toString(twoSumTwoPassHashTable(nums, target)));
        System.out.println("2: " + Arrays.toString(onePassHashTable(nums, target)));
        System.out.println();

        nums = new int[]{3, 3};
        target = 6;
        System.out.println("3: " + Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println("3: " + Arrays.toString(twoSumTwoPassHashTable(nums, target)));
        System.out.println("3: " + Arrays.toString(onePassHashTable(nums, target)));
        System.out.println();

        nums = new int[]{3, 2, 3};
        target = 6;
        System.out.println("4: " + Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println("4: " + Arrays.toString(twoSumTwoPassHashTable(nums, target)));
        System.out.println("4: " + Arrays.toString(onePassHashTable(nums, target)));
        System.out.println();

        nums = new int[]{150, 24, 79, 50, 88, 345, 3};
        target = 200;
        System.out.println("5: " + Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println("5: " + Arrays.toString(twoSumTwoPassHashTable(nums, target)));
        System.out.println("5: " + Arrays.toString(onePassHashTable(nums, target)));
    }

    /**
     * Approach #1: Brute Force
     * <p>
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    private static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Approach #2: Two-pass Hash Table
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n) the extra space required depends on the number
     * of items stored in the hash table, which stores exactly n elements
     */
    private static int[] twoSumTwoPassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Approach #3: Two-pass Hash Table
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n) the extra space required depends on the number
     * of items stored in the hash table, which stores exactly n elements
     */
    private static int[] onePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
