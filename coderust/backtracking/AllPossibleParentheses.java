package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all parentheses combinations for a given value 'n' such that they are balanced.
 * <p>
 * Runtime Complexity: Exponential.
 * For more details about complexity, look at Catalan Numbers.
 * Memory Complexity: Linear, O(n).
 * Recursive solution will consume memory on the stack.
 */
public class AllPossibleParentheses {

    public static void main(String[] args) {
        AllPossibleParentheses.printAllParentheses(3);
    }

    private static void printList(List<Character> l) {
        for (Character c : l) {
            System.out.print(c);
        }
        System.out.println();
    }

    private static void printAllParenthesesRec(int n, int leftCount, int rightCount,
                                               List<Character> output) {
        if (leftCount >= n && rightCount >= n) {
            printList(output);
        }
        if (leftCount < n) {
            output.add('{');
            printAllParenthesesRec(n, leftCount + 1, rightCount, output);
            output.remove(output.size() - 1);
        }
        if (rightCount < leftCount) {
            output.add('}');
            printAllParenthesesRec(n, leftCount, rightCount + 1, output);
            output.remove(output.size() - 1);
        }
    }

    private static void printAllParentheses(int n) {
        List<Character> output = new ArrayList<>();
        printAllParenthesesRec(n, 0, 0, output);
    }
}
