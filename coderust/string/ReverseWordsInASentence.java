package string;

public class ReverseWordsInASentence {

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumped over the lazy dog.\0";
        String s1 = "", s2 = "";
        long start = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            s1 = String.valueOf(reverseWords(sentence.toCharArray()));
        }
        long finish = System.nanoTime();
        long timeConsumedMillis = finish - start;
        System.out.println("1: " + timeConsumedMillis);
        System.out.println(s1);
        sentence = "The quick brown fox jumped over the lazy dog.";
        String[] words = sentence.split(" ");
        start = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            s2 = reverseWithSb(words);
        }
        finish = System.nanoTime();
        timeConsumedMillis = finish - start;
        System.out.println("2: " + timeConsumedMillis);
        System.out.println(s2);
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

        // Arrays.copyOf(sentence, sentence.length - 1);
        return sentence;
    }

    static String reverseWithSb(String[] words) {
        StringBuilder res = new StringBuilder();

        for (int i = (words.length - 1); i > 0; i--) {
            res.append(words[i]).append(" ");
        }

        res.append(words[0]);
        return res.toString();
    }
}