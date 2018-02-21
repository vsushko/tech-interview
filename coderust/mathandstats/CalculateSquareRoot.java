package mathandstats;

/**
 * Given a double number, write a function to calculate its square root.
 * <p>
 * Solution #1
 * Runtime Complexity: Logarithmic, O(logn).
 * Memory Complexity: Constant, O(1).
 * <p>
 * Solution #2
 * Runtime Complexity: Logarithmic, O(logn).
 * Memory Complexity: Logarithmic, O(logn).
 * Recursive solution has O(logn) memory complexity as it will consume memory on the stack.
 */
public class CalculateSquareRoot {

    private static final double EPSILON = 0.00001;

    public static void main(String[] args) {
        System.out.println("Square root iterative:");
        System.out.println("Square root of 16: is " + squareRootIterative(16));
        System.out.println("Square root of 17: is " + squareRootIterative(17));
        System.out.println("Square root of 2.25: is " + squareRootIterative(2.25));
        System.out.println("Square root recursive:");
        System.out.println("Square root of 16: is " + squareRootRecursive(16));
        System.out.println("Square root of 17: is " + squareRootRecursive(17));
        System.out.println("Square root of 2.25: is " + squareRootRecursive(2.25));
    }

    private static double squareRootIterative(double num) {
        double low = 0;

        // square root can never be more than half of number except if number is <=1
        // so square root of any number always lie between 0 and 1 + (num/2)
        double high = 1 + num / 2;

        while (low < high) {
            double mid = (low + high) / 2;
            double sqr = mid * mid;

            // we can't do a==b for doubles because of rounding errors, so we use error
            // threshold EPSILON. Two doubles a and b are equal if abs(a-b) <= EPSILON
            double diff = Math.abs(num - sqr);
            if (diff <= EPSILON) {
                return mid;
            }
            if (sqr < num) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    private static double squareRootRec(double num, double low, double high) {
        double mid = (low + high) / 2;
        // we can't do a==b for doubles because of rounding errors, so we use error
        // threshold EPSILON. Two doubles a and b are equal if abs(a-b) <= EPSILON
        double sqr = mid * mid;
        double diff = Math.abs(sqr - num);
        if (diff <= EPSILON) {
            return mid;
        }
        if (sqr < num) {
            return squareRootRec(num, mid, high);
        }
        return squareRootRec(num, low, mid);
    }

    private static double squareRootRecursive(double num) {
        return squareRootRec(num, 0, 1 + num / 2);
    }
}
