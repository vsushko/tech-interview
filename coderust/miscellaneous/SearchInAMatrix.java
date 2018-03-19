package miscellaneous;

import common.Pair;

import java.util.Arrays;

/**
 * Search (find position of) a given key in 2D matrix.
 * All rows and columns are sorted.
 * <p>
 * Runtime Complexity: Linear, O(m+n) where 'm' is number of rows
 * and 'n' is number of columns.
 * Memory Complexity: Constant, O(1).
 */
public class SearchInAMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {2, 4, 9, 13},
                {3, 5, 11, 18},
                {6, 8, 16, 21},
                {9, 11, 20, 25}
        };
        Pair<Integer, Integer> pair = searchInMatrix(matrix, 16);

        System.out.println(pair.first + " " + pair.second);
    }

    private static Pair<Integer, Integer> searchInMatrix(int matrix[][], int value) {
        int M = matrix.length; // rows
        int N = matrix[0].length; // columns

        // let's start searching from top right.
        // alternatively, searching from bottom left i.e matrix[M-1][0] can also work

        int i = 0, j = N - 1;

        while (i < M && j >= 0) {
            if (matrix[i][j] == value) {
                return new Pair<>(i, j);
            } else if (value < matrix[i][j]) {
                // search left
                --j;
            } else {
                // search down
                ++i;
            }
        }
        return new Pair<>(-1, 1);
    }

}
