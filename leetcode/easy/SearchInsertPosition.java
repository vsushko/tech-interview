package easy;

/**
 * 35. Search Insert Position
 *
 * @author vsushko
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println("2=" + searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println("1=" + searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println("4=" + searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println("0=" + searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    private static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}