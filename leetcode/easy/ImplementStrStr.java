package easy;

/**
 * 28. Implement strStr()
 *
 * @author vsushko
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("mississippi", "pi"));
        System.out.println(strStr("aaa", "a"));
        System.out.println(strStr("", "a"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("mississippi", "a"));
        System.out.println(strStr("mississippi", "issip"));
    }

    private static int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if ("".equals(haystack)) {
            return -1;
        }
        if ("".equals(needle) || haystack.equals(needle) ||
                needle.length() == 1 && haystack.charAt(0) == needle.charAt(0)) {
            return 0;
        }
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (haystackLength < needleLength) {
            return -1;
        }

        int i = 0;
        int j = 0;
        while (i < haystackLength && j < needleLength) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == needleLength) {
                return i - j;
            }
        }
        return -1;
    }

}