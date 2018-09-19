package medium;

/**
 * 62. Unique Paths
 * <p>
 * Analytical solution: (n-1 + m-1)! / ( (n-1)! * (m-1)! )
 *
 * @author vsushko
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println("uniquePaths(3, 2): " + uniquePaths2(3, 2));
        System.out.println("uniquePaths(3, 2): " + uniquePaths2(3, 2));
        System.out.println("uniquePaths(3, 2): " + uniquePathsRec(3, 2));
        System.out.println("uniquePaths(7, 3): " + uniquePaths(7, 3));
        System.out.println("uniquePaths(7, 3): " + uniquePaths2(7, 3));
        System.out.println("uniquePaths(7, 3): " + uniquePathsRec(7, 3));
    }

    private static int uniquePaths(int m, int n) {
        int[][] array = new int[m][n];

        for (int i = 0; i < m; i++) {
            array[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            array[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }

        return array[m - 1][n - 1];
    }

    private static int uniquePathsRec(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }
        return uniquePathsRec(n - 1, m) + uniquePathsRec(n, m - 1);
    }

    private static int uniquePaths2(int n, int m) {
        return new UniquePaths() {
            private int rows = n;
            private int columns = m;

            int uniquePaths2(int n, int m) {
                if (n == rows || m == columns) {
                    return 0;
                }
                if (n == rows - 1 && m == columns - 1) {
                    return 1;
                }
                return uniquePaths2(n + 1, m) + uniquePaths2(n, m + 1);
            }
        }.uniquePaths2(0, 0);
    }
}
