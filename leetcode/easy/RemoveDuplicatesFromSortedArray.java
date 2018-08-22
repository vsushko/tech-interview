package easy;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * @author Vasiliy Sushko
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(array));
        array = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(array));
    }

    /**
     * Approach 1: Two Pointers
     * Time complexity: O(n), assume that n is the length of array,
     * each i and j traverses at most n steps
     * Space complexity: O(1)
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
