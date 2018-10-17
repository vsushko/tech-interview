package easy;

/**
 * 443. String Compression
 *
 * @author vsushko
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("aaabb".toCharArray()));
        System.out.println(compress("aabb".toCharArray()));
        System.out.println(compress("ab".toCharArray()));
        System.out.println(compress("abc".toCharArray()));
        System.out.println(compress("zzz".toCharArray()));
    }

    private static int compress(char[] chars) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < chars.length) {
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                chars[j] = chars[k];
                j++;
                if (i > k) {
                    char[] digits = String.valueOf(i - k + 1).toCharArray();
                    for (char digit : digits) {
                        chars[j] = digit;
                        j++;
                    }
                }
                k = i + 1;
            }
            i++;
        }
        return j;
    }
}
