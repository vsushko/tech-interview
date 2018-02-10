package string;

public class RemoveWhiteSpaces {

    public static void main(String[] args) {
        String test = "     All greek  to    me.     \0";
        System.out.println(removeWhiteSpaces(test.toCharArray()));

    }

    private static boolean isWhiteChar(char c) {
        // there can be more white space characters
        // but for simplicity lets assume that we have
        // only two white space character i.e. space and tab
        if (c == ' ' || c == '\t') {
            return true;
        }
        return false;
    }

    private static char[] removeWhiteSpaces(char[] s) {
        if (s == null || s.length == 0 || s[0] == '\0') {
            return new char[]{};
        }
        // we will use read, write pointers here. Write pointer will follow
        // the read pointer and only write characters read that are neither
        // a space (' ') nor a tab ('\t').

        int readPtr = 0;
        int writePtr = 0;

        while (readPtr < s.length && s[readPtr] != '\0') {
            // lets assume there are only two white space characters: space and tab
            if (!isWhiteChar(s[readPtr])) {
                s[writePtr] = s[readPtr];
                ++writePtr;
            }
            ++readPtr;
        }
        // let's mark the end of string
        s[writePtr] = '\0';
        return s;
    }
}
