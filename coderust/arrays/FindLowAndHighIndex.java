package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLowAndHighIndex {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(
                Arrays.asList(1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20));

        System.out.println("Low index: " + findLowIndex(array, 5));
        System.out.println("High index: " + findHighIndex(array, 5));
    }

    static int findLowIndex(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;

        while (low <= high) {
            int midElem = arr.get(mid);

            if (midElem < key) {
                low = low + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        if (arr.get(low) == key) {
            return low;
        }
        return -1;
    }
    private static int findHighIndex(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;

        while (low <= high) {
            int midElem = arr.get(mid);

            if (midElem <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        if (arr.get(high) == key) {
            return high;
        }
        return -1;
    }
}