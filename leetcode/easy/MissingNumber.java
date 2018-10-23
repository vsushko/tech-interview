package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 268. Missing number
 *
 * @author vsushko
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 1};
        System.out.println(missingNumber1(arr));
        System.out.println(missingNumber2(arr));
        System.out.println(missingNumber3(arr));
        System.out.println(missingNumber4(arr));
        System.out.println(missingNumber5(arr));
        arr = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber1(arr));
        System.out.println(missingNumber2(arr));
        System.out.println(missingNumber3(arr));
        System.out.println(missingNumber4(arr));
        System.out.println(missingNumber5(arr));
    }

    /**
     * Brute force for O(n)
     */
    private static int missingNumber1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        for (int i = 1; i <= n; i++) {
            sum2 += i;
        }
        return sum2 - sum;
    }

    /**
     * Sorting for O(nlog(n)) with avoiding additional space allocation,
     * if modifying nums is forbidden, we can allocate an O(n) size copy
     * array and sort that instead
     */
    private static int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        } else {
            if (nums[0] != 0) {
                return 0;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i - 1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        return -1;
    }

    /**
     * HashSet for O(n) and O(n) space complexity
     */
    private static int missingNumber3(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int expectedNumCount = nums.length + 1;

        for (int i = 0; i < expectedNumCount; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Bit manipulation with XOR operation, tc: O(n), sc: O(1),
     * XOR is a constant-time operation
     */
    private static int missingNumber4(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * Gauss' Formula of tc: O(N), sc: O(1)
     */
    private static int missingNumber5(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        return (n * (n + 1) / 2) - sum;
    }
}
