package easy;

/**
 * 7. Reverse Integer
 * <p>
 * https://leetcode.com/problems/reverse-integer
 *
 * @author vsushko
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int n = 123;
        System.out.println(n + "->" + reverse(n));
        System.out.println(n + "->" + popAndPushDigitsReverse(n));
        n = -123;
        System.out.println(n + "->" + reverse(n));
        System.out.println(n + "->" + popAndPushDigitsReverse(n));
        n = 120;
        System.out.println(n + "->" + reverse(n));
        System.out.println(n + "->" + popAndPushDigitsReverse(n));
        n = 1534236469;
        System.out.println(n + "->" + reverse(n));
        System.out.println(n + "->" + popAndPushDigitsReverse(n));
        n = -2147483648;
        System.out.println(n + "->" + reverse(n));
        System.out.println(n + "->" + popAndPushDigitsReverse(n));
    }

    /**
     * Approach #1: Pop and Push Digits & Check before Overflow
     * <p>
     * Time Complexity: O(log(x)). There are roughly log10(x) digits in x
     * Space Complexity: O(1)
     */
    private static int popAndPushDigitsReverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * Time complexity : O(n) where n is the number of digit
     */
    public static int reverse(int x) {
        long result = 0;
        long xRemaining = Math.abs(x);
        while (xRemaining != 0) {
            long firstAddendum = result * 10;
            if (firstAddendum > Integer.MAX_VALUE || firstAddendum < Integer.MIN_VALUE) {
                return 0;
            }
            result = (int) firstAddendum + xRemaining % 10;
            xRemaining /= 10;
        }
        return x < 0 ? (int) -result : (int) result;
    }
}