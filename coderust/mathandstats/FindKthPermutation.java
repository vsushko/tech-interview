package mathandstats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of n elements find their kth permutation.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Linear, O(n).
 * Recursive solution will consume memory on the stack.
 */
public class FindKthPermutation {

    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>(Arrays.asList('1', '2', '3', '4'));
        StringBuilder stringBuilder = new StringBuilder();
        findKthPermutation(characters, 3, stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static void findKthPermutation(List<Character> v, int k, StringBuilder result) {
        if (v.isEmpty()) {
            return;
        }
        int n = v.size();
        // count is number of permutations starting with first digit
        int count = factorial(n - 1);
        int selected = (k - 1) / count;

        result.append(v.get(selected));
        v.remove(selected);

        k = k - (count * selected);
        findKthPermutation(v, k, result);
    }

}
