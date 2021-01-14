package easy;

/**
 * 27. Remove Element
 *
 * @author vsushko
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElementTP(array, val));
        System.out.println(removeElementRR(array, val));
        System.out.println(removeElement3(array, val));
        array = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        System.out.println(removeElementTP(array, val));
        System.out.println(removeElementRR(array, val));
        System.out.println(removeElement3(array, val));
    }

    /**
     * Approach 1: Two Pointers
     * <p>
     * Time complexity: O(n), assume the array has a total of n elements,
     * both i and j traverse at most 2n steps
     * Space complexity: O(1)
     */
    private static int removeElementTP(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * Approach 2: Two Pointers - when elements to remove are rare
     * In this approach, the number of assignment operation is equal
     * to the number of elements to remove. So it is more efficient if
     * elements to remove are rare
     * <p>
     * Time complexity: O(n), both i and n traverse at most n steps
     * Space complexity: O(1)
     */
    private static int removeElementRR(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    /**
     * We need to have two indices (fast and slow) and iterate through the array elements to check if the elements
     * pointed by the fast index is same as the given value. If different, replace the slow index value with the fast
     * index value. If the values are same, skip it and move to the fast index to the next element.
     * When the fast element reaches the end, return the slow value as the number of elements in the resulting array.
     *
     * Time complexity: O(n), where n is the size of array
     * Space complexity: O(1), this algorithm usees a constant extra space
     */
    private static int removeElement3(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++){
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
