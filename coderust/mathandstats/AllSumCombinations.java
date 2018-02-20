package mathandstats;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer, print all possible sum combinations using positive integers.
 * <p>
 * Runtime Complexity: Exponential.
 * Memory Complexity: Linear, O(n).
 */
public class AllSumCombinations {

    public static void main(String[] args) {
        printAllSum(4);
    }

    private static void printList(List<Integer> v) {
        for (int i : v) {
            System.out.print(i + ",");
        }
        System.out.println("");
    }

    private static void printAllSumRec(int target, int currentSum, int start, List<Integer> output) {
        if (target == currentSum) {
            printList(output);
        }
        for (int i = start; i < target; i++) {
            int tempSum = currentSum + i;
            if (tempSum <= target) {
                output.add(i);
                printAllSumRec(target, tempSum, i, output);
                output.remove(output.size() - 1);
            } else {
                return;
            }
        }
    }

    private static void printAllSum(int target) {
        List<Integer> output = new ArrayList<>();
        printAllSumRec(target, 0, 1, output);
    }
}
