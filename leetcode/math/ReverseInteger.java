package math;

/**
 * 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int n = 123;
        System.out.println(n + "->" + reverse(n));
        n = -123;
        System.out.println(n + "->" + reverse(n));
        n = 120;
        System.out.println(n + "->" + reverse(n));
        n = 1534236469;
        System.out.println(n + "->" + reverse(n));
        n = -2147483648;
        System.out.println(n + "->" + reverse(n));
    }

    /**
     * Time complexity : O(n) where n is the number of digit
     */
    public static int reverse(int x) {
        long result = 0;
        long xRemaining = Math.abs(x);
        while (xRemaining != 0) {
            long firstAddendum = result * 10;
            if (firstAddendum > Integer.MAX_VALUE
                    || firstAddendum < Integer.MIN_VALUE) {
                return 0;
            }
            result = (int) firstAddendum + xRemaining % 10;
            xRemaining /= 10;
        }
        return x < 0 ? (int) -result : (int) result;
    }
}