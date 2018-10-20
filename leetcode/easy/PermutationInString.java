package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String
 *
 * @author vsushko
 */
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(hasSubstring("FDS".toLowerCase(), "aSDFgh".toLowerCase()));
        System.out.println(hasSubstring("ASD".toLowerCase(), "aSDFgh".toLowerCase()));
    }

    private static String hasSubstring(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return "not found";
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = s1.length();
        while (left <= s2.length() - s1.length()) {
            Map<Character, Integer> map2 = new HashMap<>();
            for (int i = left; i < right; i++) {
                map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
            }
            if (hasSameSymbols(map1, map2)) {
                return s2;
            }
            left++;
            right++;
        }
        return "not found";
    }

    private static boolean hasSameSymbols(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            if (!value.equals(map2.get(key))) {
                return false;
            }
        }
        return true;
    }
}
