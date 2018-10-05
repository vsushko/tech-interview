package easy;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 *
 * @author vsushko
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram1(s, t));
        System.out.println(isAnagram2(s, t));
        System.out.println(isAnagram3(s, t));
        System.out.println(isAnagram4(s, t));
        System.out.println(isAnagram5(s, t));
        s = "rat";
        t = "car";
        System.out.println(isAnagram1(s, t));
        System.out.println(isAnagram2(s, t));
        System.out.println(isAnagram3(s, t));
        System.out.println(isAnagram4(s, t));
        System.out.println(isAnagram5(s, t));
    }

    /**
     * Brute-force solution
     */
    private static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        char[] tc = t.toCharArray();
        Arrays.sort(tc);

        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != tc[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach #1 (Sorting)
     * Time complexity : O(n log(n))
     * Space complexity : O(1)
     */
    private static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        char[] tc = t.toCharArray();
        Arrays.sort(tc);

        return Arrays.equals(sc, tc);
    }

    /**
     * Approach #2 (Hash Table)
     * Time complexity : O(n)
     * Space complexity: O(1)
     */
    private static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach #2 (Hash Table)
     */
    private static boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 3ms
     */
    private static boolean isAnagram5(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        String s1 = getAnagram(s);
        String s2 = getAnagram(t);
        return s1.equals(s2);
    }

    private static String getAnagram(String s) {
        char[] ch = new char[26];

        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a']++;
        }

        return new String(ch);
    }

    /**
     * 2ms
     */
    public boolean isAnagram6(String s, String t) {
        int[] cc = new int[256];
        for (char c : s.toCharArray()) {
            cc[c]++;
        }
        for (char c : t.toCharArray()) {
            cc[c]--;
        }
        for (int ct : cc) {
            if (ct != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1ms
     */
    public boolean isAnagram7(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }

        int[] dict = new int[26];

        for (char c : s.toCharArray()) {
            dict[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            dict[c - 'a']--;
        }

        for (int i : dict) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
