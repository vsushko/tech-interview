package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * <p>
 * https://leetcode.com/problems/roman-to-integer
 *
 * @author vsushko
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println("3=" + romanToInt("III"));
        System.out.println("4=" + romanToInt("IV"));
        System.out.println("9=" + romanToInt("IX"));
        System.out.println("58=" + romanToInt("LVIII"));
        System.out.println("1994=" + romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        int i = 0;
        while (i < s.length() - 1) {
            int j = i + 1;
            int num1 = map.get(s.charAt(i));
            int num2 = map.get(s.charAt(j));
            if (num2 > num1) {
                result += (num2 - num1);
                i += 2;
            } else {
                result += num1;
                i++;
            }
        }
        if (i < s.length()) {
            result += map.get(s.charAt(s.length() - 1));
        }
        return result;
    }
}
