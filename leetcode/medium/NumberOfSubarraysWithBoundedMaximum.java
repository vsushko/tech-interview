package medium;

/**
 * 795. Number of Subarrays with Bounded Maximum
 */
public class NumberOfSubarraysWithBoundedMaximum {

    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 4, 3};
        System.out.println(numSubarrayBoundedMax(A, 2, 3));
    }

    private static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count = 0;
        int result = 0;
        int j = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                result += i - j + 1;
                count = i - j + 1;
            } else if (A[i] < L) {
                result += count;
            } else {
                j = i + 1;
                count = 0;
            }
        }
        return result;
    }
}
