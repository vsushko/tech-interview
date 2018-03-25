package hard;

/**
 * 805. Split Array With Same Average
 * <p>
 * In a given integer array A, we must move every element of A
 * to either list B or list C. (B and C initially start empty.)
 * <p>
 * Return true if and only if after such a move, it is possible
 * that the average value of B is equal to the average value of C,
 * and B and C are both non-empty.
 */
public class SplitArrayWithSameAverage {

    public static void main(String[] args) {
        int A[] = new int[]{3, 1};
        System.out.println(splitArraySameAverage(A));
    }

    public static boolean splitArraySameAverage(int[] A) {
        int sum = 0, ARRAY_SIZE = A.length;
        for (int someInt : A) {
            sum += someInt;
        }

        for (int i = 1; i <= ARRAY_SIZE / 2; i++) {
            if (sum * i % ARRAY_SIZE != 0)
                continue;

            if (checkSumRec(A, sum * i / ARRAY_SIZE, i, 0, 0, 0))
                return true;
        }

        return false;
    }

    private static boolean checkSumRec(int[] A, int sum, int num, int start, int curSum, int curCount) {
        if (curCount == num && sum == curSum) {
            return true;
        }
        if (curCount == num) {
            return false;
        }

        for (int i = start; i < A.length; i++) {
            if (curSum + A[i] <= sum) {
                if (checkSumRec(A, sum, num, i + 1, curSum + A[i], curCount + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
