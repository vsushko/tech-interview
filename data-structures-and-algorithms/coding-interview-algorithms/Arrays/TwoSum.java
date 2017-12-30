import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * Created by vsushko on 30.12.2017.
 */
public class TwoSum {

    public static void main(String[] args) {
        int target = 7;
        int[] array = new TwoSum().twoSum(new int[]{1, 2, 3, 4}, target);

        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
    }

    /**
     * Time Complexity: O(N)
     * The array is traversed only once. So the time complexity is
     * directly proportional to the size of the array i.e O(N).
     * <p>
     * Space Complexity: O(N)
     * O(1)+O(N)=O(N). O(1) for the variables and O(N) for the hashmap. For hashmap,
     * with the increase of the number of entrries, the hashmap's space will increase linearly.
     * So Space complexity of hashmap is O(N).
     *
     * @param nums   the nums
     * @param target the target
     * @return array
     */
    private int[] twoSum(int[] nums, int target) {
        // array to return the result
        int[] arr = new int[2];

        // map for num and index pair
        Map<Integer, Integer> map = new HashMap<>();

        // iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // check if the map has an element which is equal to the difference
            // between the target and current element
            Integer val = map.get(target - nums[i]);
            if (val == null) {
                // no match found, add the current item and index to map
                map.put(nums[i], i);
            } else {
                // match found, update the index values
                arr[0] = val;
                arr[1] = i;
                // exit the loop
                break;
            }
        }
        return arr;
    }
}
