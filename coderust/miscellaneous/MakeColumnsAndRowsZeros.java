package miscellaneous;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a two dimensional array, if any element in it is zero make its
 * whole row and column zero.
 * <p>
 * Runtime Complexity: O(m.n) where m is number of rows and n
 * is number of columns.
 * Memory Complexity:  O(m + n).
 */
public class MakeColumnsAndRowsZeros {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 4, 3, 9},
                {2, 0, 7, 6},
                {1, 3, 4, 0},
                {9, 8, 3, 4}
        };
        makeZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n")
                .replace("[[", "[").replace("]]", "]"));
    }

    private static void makeZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    if (!zeroRows.contains(i)) {
                        zeroRows.add(i);
                    }
                    if (!zeroCols.contains(j)) {
                        zeroCols.add(j);
                    }
                }
            }
        }
        for (int r : zeroRows) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = 0;
            }
        }
        for (int c : zeroCols) {
            for (int r = 0; r < rows; r++) {
                matrix[r][c] = 0;
            }
        }
    }
}
