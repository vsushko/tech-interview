package easy;

/**
 * 53. Maximum Subarray
 *
 * @author vsushko
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println("6=" + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("6=" + maxSubArray(new int[]{1, 10, -1, 11, 5, -30, -7, 20, 25, -35}));
        System.out.println("6=" + maxSubArray(new int[]{-15, -14, -10, -19, -5, -21, -10}));
    }

    /**
     * Runtime complexity: linear, O(n)
     * Space complexity: constant, O(1)
     */
    private static int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int currentMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentMax < 0) {
                currentMax = nums[i];
            } else {
                currentMax += nums[i];
            }
            if (globalMax < currentMax) {
                globalMax = currentMax;
            }
        }
        return globalMax;
    }
}
