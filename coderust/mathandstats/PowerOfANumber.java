package mathandstats;

/**
 * Given a double 'x' and an integer 'n'. Write a function to calculate 'x'
 * raised to the power 'n'.
 * <p>
 * Runtime Complexity: Logarithmic, O(logn).
 * Memory Complexity: Logarithmic, O(log n).
 * The recursive solution has O(logn) memory complexity as it will
 * consume memory on the stack.
 */
public class PowerOfANumber {

    public static void main(String[] args) {
        System.out.println("power(2,5): " + power(2, 5));
        System.out.println("power(3,4): " + power(3, 4));
        System.out.println("power(1.5,3): " + power(1.5, 3));
        System.out.println("power(2,-2): " + power(2, -2));
    }

    private static double powerRec(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double temp = powerRec(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    private static double power(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        }
        double result = powerRec(x, n);
        if (isNegative) {
            return 1 / result;
        }
        return result;
    }
}
