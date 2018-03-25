package medium;

public class MaxIncreaseToKeepCitySkyline {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{3, 0, 8, 4},
                {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int GRID_SIZE = grid.length;
        int[] rows = new int[GRID_SIZE];
        int[] cols = new int[GRID_SIZE];

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] > rows[i]) {
                    rows[i] = grid[i][j];
                }
                if (grid[i][j] > cols[j]) {
                    cols[j] = grid[i][j];
                }
            }
        }
        int result = 0;

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                int minValue = Math.min(rows[i], cols[j]);
                result += minValue - grid[i][j];
            }
        }

        return result;
    }
}
