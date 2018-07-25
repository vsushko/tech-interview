package easy;

public class PascalTriangle {

    private static int[] nthPascalRow(int row) {
        if (row == 0) {
            return new int[]{1};
        }
        if (row == 1) {
            return new int[]{1, 1};
        }
        int[] previous = {1, 1};
        for (int r = 2; r <= row; r++) {
            int[] next = new int[r + 1];
            next[0] = 1;
            for (int i = 1; i < r; i++) {
                next[i] = previous[i - 1] + previous[i];
            }
            next[r] = 1;
            previous = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            int[] result = nthPascalRow(i);
            for (int element : result) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
