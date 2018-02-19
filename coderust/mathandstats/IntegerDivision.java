package mathandstats;

/**
 * Divide two integers without using '/' (division) or '*' (multiplication) operators.
 * <p>
 * Runtime Complexity: Logarithmic, O(logn).
 * Memory Complexity: Logarithmic, O(logn).
 * <p>
 * Recursive solution has O(logn) memory complexity as it will consume memory on the stack.
 */
public class IntegerDivision {

    public static void main(String[] args) {
        System.out.println("7/2=" + integerDivide(7, 2));
        System.out.println("5/4=" + integerDivide(5, 4));
        System.out.println("1/3=" + integerDivide(1, 3));
    }

    private static int integerDivide(int x, int y) {
        // we will return -1 if the divisor is '0'.
        if (y == 0) {
            return -1;
        }
        if (x < y) {
            return 0;
        } else if (x == y) {
            return 1;
        } else if (y == 1) {
            return x;
        }

        int q = 1;
        int val = y;

        while (val < x) {
            val <<= 1;
            // we can also use 'val= val +val;'
            q <<= 1;
            // we can also use 'q = q + q;'
        }
        if (val > x) {
            val >>= 1;
            q >>= 1;
            return q + integerDivide(x - val, y);
        }
        return q;
    }
}
