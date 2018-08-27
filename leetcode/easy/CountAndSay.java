package easy;

/**
 * 38. Count and Say
 *
 * @author vsushko
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println("1=" + countAndSay(1));
        System.out.println("11=" + countAndSay(2));
        System.out.println("21=" + countAndSay(3));
        System.out.println("1211=" + countAndSay(4));
        System.out.println("111221=" + countAndSay(5));
    }

    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);

        StringBuilder builder = new StringBuilder();
        char say = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == say) {
                count++;
            } else {
                builder.append(count).append(say);
                count = 1;
                say = c;
            }
        }
        builder.append(count).append(say);
        return builder.toString();
    }
}
