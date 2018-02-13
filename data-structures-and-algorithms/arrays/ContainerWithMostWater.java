package arrays;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i,0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: you may not slant the container and n is at least 2.
 * <p>
 * Created by vsushko on 31.12.2017.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 1, 1, 1, 1}));
    }

    /**
     * Time Complexity: O(N)
     * This solution runs in O(N) time complexity where N is the size of the array
     * <p>
     * Space Complexity O(1)
     * This algorithm uses a constant extra space
     *
     * @param height array
     * @return maxArea
     */
    private int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
