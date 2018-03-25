package easy;

import java.util.Arrays;

/**
 * 806. Number of Lines To Write String
 * <p>
 * We are to write the letters of a given string S, from left to right into lines.
 * Each line has maximum width 100 units, and if writing a letter would cause the
 * width of the line to exceed 100 units, it is written on the next line.
 * We are given an array widths, an array where widths[0] is the width of 'a',
 * widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 * <p>
 * Now answer two questions: how many lines have at least one character from S,
 * and what is the width used by the last such line? Return your answer as an integer list of length 2.
 */
public class NumberOfLinesToWriteString {

    public static void main(String[] args) {
        int[] widths = new int[]{10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10};
        String S = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(numberOfLines(widths, S)));

        widths = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10};
        S = "bbbcccdddaaa";
        System.out.println(Arrays.toString(numberOfLines(widths, S)));
    }

    public static int[] numberOfLines(int[] widths, String S) {
        int unitsCount = 0, lineCount = 0;

        for (char character : S.toCharArray()) {
            int width = widths[character - 'a'];
            if (unitsCount + width > 100) {
                lineCount++;
                unitsCount = width;
            } else {
                unitsCount += width;
            }
        }
        return new int[]{lineCount + (unitsCount > 0 ? 1 : 0), unitsCount};
    }


}
