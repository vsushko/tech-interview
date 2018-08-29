package easy;

import java.util.Arrays;

/**
 * 66. Plus One
 *
 * @author vsushko
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println("124=" + Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println("4322=" + Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println("5000=" + Arrays.toString(plusOne(new int[]{4, 9, 9, 9})));
        System.out.println("10000=" + Arrays.toString(plusOne(new int[]{9, 9, 9, 9})));
    }

    private static int[] plusOne(int[] digits) {
        int length = digits.length;

        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[length + 1];
        newDigits[0] = 1;

        return newDigits;
    }
}
