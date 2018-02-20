package mathandstats;

/**
 * Implement a method to print all permutations of a given string.
 * <p>
 * Runtime Complexity: Factorial, O(n!)
 * Memory Complexity: Linear, O(n)
 * Recursive solution has O(n) memory complexity as it will consume memory
 * on the stack for the recursive calls.
 */
public class PermuteString {

    public static void main(String[] args) {
        permuteString("bad");
    }

    private static void swapChar(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static void permuteString(char[] input, int currentIndex, int endingIndex) {
        if (currentIndex == endingIndex) {
            System.out.print(input);
            System.out.println();
            return;
        }
        for (int i = currentIndex; i <= endingIndex; i++) {
            swapChar(input, currentIndex, i);
            permuteString(input, currentIndex + 1, endingIndex);
            swapChar(input, currentIndex, i);
        }
    }

    private static void permuteString(String input) {
        permuteString(input.toCharArray(), 0, input.length() - 1);
    }
}
