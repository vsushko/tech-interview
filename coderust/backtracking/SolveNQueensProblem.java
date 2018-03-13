package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a chess board of size N x N, determine how many ways N queens can be placed
 * on this board so that no two queens attack each other.
 * <p>
 * Solution # 1
 * Runtime Complexity: Factorial, O(n!).
 * The recurrence relation for time complexity is:
 * T(n) = nT(n-1) + O(n^2)T(n)=nT(n−1)+O(n^​2)
 * <p>
 * Memory Complexity: Exponential.
 * The number of solutions grow exponentially. Recursive solution will consume memory on the stack as well.
 * <p>
 * Solution #2
 * Runtime Complexity: Exponential.
 * Memory Complexity: Exponential.
 * The number of solutions grow exponentially. Memory consumed by the stack will be linear, O(n) in this solution
 * as there won't be more than 'n' elements in the stack at one time.
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

    private static void solveNQueens2(int n, List<List<Integer>> results) {
        List<Integer> solution = new ArrayList<>(n);
        Stack<Integer> solStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            solution.add(-1);
        }
        int row = 0;
        int col = 0;

        while (row < n) {
            while (col < n) {
                if (isValidMove(row, col, solution)) {
                    solStack.push(col);
                    solution.set(row, col);
                    row++;
                    col = 0;
                    break;
                }
                col++;
            }
            if (col == n) {
                if (!solStack.empty()) {
                    col = solStack.peek() + 1;
                    solStack.pop();
                    row--;
                } else {
                    // no more solutions exist
                    break;
                }
            }
            if (row == n) {
                // add the solution in to results
                results.add(new ArrayList<>(solution));

                // backtrack to find the next solution
                row--;
                col = solStack.peek() + 1;
                solStack.pop();
            }
        }
    }
}
