package easy;

/**
 * 387. First Unique Character in a String
 *
 * @author vsushko
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        System.out.println("0 = " + firstUniqChar("leetcode"));
        System.out.println("2 = " + firstUniqChar("loveleetcode"));
    }

    private static int firstUniqChar(String s) {
        int[] charSet = new int[128];
        for (int i = 0; i < s.length(); i++) {
            charSet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charSet[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
