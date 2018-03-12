package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a chess board of size N x N, determine how many ways N queens can be placed
 * on this board so that no two queens attack each other.
 */
public class SolveNQueensProblem {

    public static void main(String[] args) {

    }


    // this method determines if a queen can be placed at proposed_row, proposed_col
    // with current solution i.e. this move is valid only if no queen in current
    // solution should attacked square at proposed_row and proposed_col
    private static boolean isValidMove(int proposedRow, int proposedCol,
                                       List<Integer> solution) {
        // we need to check with all queens in current solution
        for (int i = 0; i < proposedRow; i++) {
            int oldRow = i;
            int oldCol = solution.get(i);

            int diagonalOffset = proposedRow - oldRow;
            if (oldCol == proposedCol || oldCol == proposedCol - diagonalOffset ||
                    oldCol == proposedCol + diagonalOffset) {
                return false;
            }
        }
        return true;
    }

    private static void solveNQueensRec(int n, List<Integer> solution, int row,
                                        List<List<Integer>> results) {
        if (row == n) {
            results.add(new ArrayList<>(solution));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValidMove(row, i, solution)) {
                solution.set(row, i);
                solveNQueensRec(n, solution, row + 1, results);
            }
        }
    }

    private static void solveNQueens(int n, List<List<Integer>> results) {
        List<Integer> solution = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            solution.add(-1);
        }
        solveNQueensRec(n, solution, 0, results);
    }
}
