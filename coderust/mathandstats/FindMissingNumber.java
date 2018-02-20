package mathandstats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of positive numbers from 1 to n, such that all numbers
 * from 1 to n are present except one. Find the missing number.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant, O(1).
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(3, 7, 1, 2, 8, 4, 5));
        System.out.println(findMissing(integers));
    }

    private static int findMissing(List<Integer> input) {
        // calculate sum of all elements in input list
        int sumOfElements = 0;
        for (Integer x : input) {
            sumOfElements += x;
        }
        // there is exactly 1 number missing
        int n = input.size() + 1;
        int actualSum = (n * (n + 1)) / 2;

        return actualSum - sumOfElements;
    }
}
