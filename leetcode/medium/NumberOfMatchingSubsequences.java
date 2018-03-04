package medium;

/**
 * 792. Number of Matching Subsequences
 */
public class NumberOfMatchingSubsequences {

    public static void main(String[] args) {
        String S = "abcde";
        String[] words = new String[]{"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(S, words));
    }

    private static int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubsequence(S, word))
                count++;
        }
        return count;
    }

    // use binary search
    private static boolean isSubsequence(String word, String dictionaryWord) {
        int i = 0, j = 0;
        int currentWordLength = word.length();
        int dictionaryWordLength = dictionaryWord.length();

        if (dictionaryWordLength > currentWordLength) {
            return false;
        }
        while (i < currentWordLength && j < dictionaryWordLength) {
            if (word.charAt(i) == dictionaryWord.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == dictionaryWordLength;
    }
}
