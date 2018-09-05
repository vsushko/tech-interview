package ch1arraysandstrings;

public class CheckPermutation {

    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean permutation1(String s, String t) {
        return sort(s).equals(sort(t));
    }

    public static boolean permutation2(String s, String t) {
        // Permutations must be same length
        if (s.length() != t.length()) {
            return false;
        }

        // Assumption: ASCII
        int[] letters = new int[128];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }

        // letters array has no negative values, and therefore no positive values either
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};

        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation1(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }

        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation2(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
