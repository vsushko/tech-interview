package mathandstats;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array find all Pythagorean triplets.
 * <p>
 * Solution #1:
 * Runtime Complexity: Polynomial, O(n3).
 * Memory Complexity: Constant, O(1).
 */
public class PythagoreanTriplets {

    public static void main(String[] args) {
        int[] array = new int[]{4, 16, 1, 2, 3, 5, 6, 8, 25, 10};

        List<int[]> pythagoreanTriplets1 = findPythagoreanTriplets1(array);
        for (int[] aPythagoreanTriplets1 : pythagoreanTriplets1) {
            for (int anAPythagoreanTriplets1 : aPythagoreanTriplets1) {
                System.out.print(anAPythagoreanTriplets1 + ", ");
            }
            System.out.println();
        }
    }

    private static boolean isPythagoreanTriplet(int a, int b, int c) {
        int sqra = a * a;
        int sqrb = b * b;
        int sqrc = c * c;

        if (sqra + sqrb == sqrc
                || sqra + sqrc == sqrb
                || sqrb + sqrc == sqra) {
            return true;
        }
        return false;
    }

    private static List<int[]> findPythagoreanTriplets1(int[] arr) {
        int n = arr.length;
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[j] == 0) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (isPythagoreanTriplet(arr[i], arr[j], arr[k])) {
                        int[] triplet = {arr[i], arr[j], arr[k]};
                        triplets.add(triplet);
                    }

                }
            }
        }
        return triplets;
    }
}
