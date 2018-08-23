package easy;

/**
 * 28. Implement strStr()
 *
 * @author vsushko
 */
public class ImplementStrStr {

    public static void main(String[] args) {
//        System.out.println(strStr("hello", "ll"));
//        System.out.println(strStr("aaaaa", "bba"));
//        System.out.println(strStr("a", "a"));
        System.out.println(strStr("mississippi", "pi"));
    }

    private static int strStr(String haystack, String needle) {
        if ("".equals(needle) || haystack.equals(needle)) {
            return 0;
        }
        int i = 0;
        int j = 0;

        while (i < haystack.length() - 1) {
            char c1 = haystack.charAt(i);
            char c2 = needle.charAt(j);

            if (c1 == c2) {
                i++;
                j++;
            } else {
                j--;
            }

            if (j == needle.length() - 1) {
                return i-j;
            }
        }
        return -1;
    }
}