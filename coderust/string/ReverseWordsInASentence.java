package string;

public class ReverseWordsInASentence {

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumped over the lazy dog.\0";
        System.out.println(reverseWords(sentence.toCharArray()));
    }
    // Null terminating strings are not used in java
    // however for this question assume you are passed a null terminated string
    private static void strRev(char[] str, int start, int end) {
        if (str == null || str.length < 2) {
            return;
        }
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            start++;
            end--;
        }
    }
    private static char[] reverseWords(char[] sentence) {
        // here sentence is a null-terminated string ending with char '\0'.
        if (sentence == null || sentence.length == 0 || sentence[0] == '\0') {
            return new char[]{};
        }

        // To reverse all words in the string, we will first reverse
        // the string. Now all the words are in the desired location, but
        // in reverse order: "Hello World" -> "dlroW olleH".
        int len = sentence.length;
        strRev(sentence, 0, len - 2);

        // Now, let's iterate the sentence and reverse each word in place.
        // "dlroW olleH"

        int start = 0;
        int end;
        while (true) {
            // find the start index of a word while skipping spaces.
            while (sentence[start] == ' ') {
                ++start;
            }
            if (sentence[start] == '\0') {
                break;
            }
            // find the end index of the word.
            end = start + 1;
            while (sentence[end] != '\0' && sentence[end] != ' ') {
                ++end;
            }
            // lets reverse the word in-place.
            strRev(sentence, start, end - 1);
            start = end;
        }
        return sentence;
    }
}