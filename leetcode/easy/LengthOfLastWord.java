package easy;

/**
 * 58. Length of Last Word
 *
 * @author vsushko
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println("5=" + lengthOfLastWord("Hello World"));
        System.out.println("0=" + lengthOfLastWord(" "));
        System.out.println("0=" + lengthOfLastWord("        "));
        System.out.println("1=" + lengthOfLastWord("a"));
        System.out.println("3=" + lengthOfLastWord("day"));
    }

    private static int lengthOfLastWord(String s) {
        if ("".equals(s) || " ".equals(s)) {
            return 0;
        }
        String[] strings = s.split(" ");
        if (strings.length >= 1) {
            String lastWord = strings[strings.length - 1];
            if (!" ".equals(lastWord)) {
                return lastWord.length();
            }
        }
        return 0;
    }
}
