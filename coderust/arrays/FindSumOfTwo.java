package arrays;

import java.util.HashSet;
import java.util.Set;

public class FindSumOfTwo {

    public static void main(String[] args) {
        int[] A = new int[]{5, 7, 1, 2, 8, 4, 3};
        System.out.println(findSumOfTwo(A, 10));

        A = new int[]{1, 3, 4, 5, 7, 14, 15};
        System.out.println(findSumOfTwo2(A, 11));

        A = new int[]{3, 2, 4};
        // TODO: LOL
        System.out.println(findSumOfTwo2(A, 6));
    }

    private static boolean findSumOfTwo(int[] A, int val) {
        Set<Integer> foundValues = new HashSet<>();
        for (int a : A) {
            if (foundValues.contains(val - a)) {
                return true;
            }
            foundValues.add(a);
        }
        return false;
    }

    private static boolean findSumOfTwo2(int[] A, int val) {
        for (int i = 0, j = A.length - 1; i < j; ) {
            int sum = A[i] + A[j];

            if (sum == val) {
                return true;
            }
            if (sum < val) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }
}
