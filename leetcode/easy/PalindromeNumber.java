package easy;

/**
 * 9. Palindrome Number
 * <p>
 * https://leetcode.com/problems/palindrome-number
 *
 * @author vsushko
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    /**
     * Approach #1: Revert half of the number
     * <p>
     * Time complexity: O(log10(n))
     * We divided the input by 10 for every iteration, so the time complexity is O(log10(n))
     * Space complexity: O(1)
     */
    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
