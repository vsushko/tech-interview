package easy;

/**
 * 14. Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix
 *
 * @author vsushko
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] firstArray = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(firstArray));
        String[] secondArray = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(secondArray));
    }

    /**
     * Approach #1: Horizontal scanning
     *
     * Time complexity: O(S), where S is the sum of all character in all strings
     * Space complexity: O(1), we only used constant extra space
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
