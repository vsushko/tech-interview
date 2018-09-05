package ch1arraysandstrings;

public class IsUnique {

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars1(word));
        }

        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars2(word));
        }

        for (String word : words) {
            boolean wordA = isUniqueChars1(word);
            boolean wordB = isUniqueChars2(word);
            if (wordA == wordB) {
                System.out.println(word + ": " + wordA);
            } else {
                System.out.println(word + ": " + wordA + " vs " + wordB);
            }
        }
    }

    public static boolean isUniqueChars1(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    /* Assumes only letters a through z. */
    public static boolean isUniqueChars2(String str) {
        // Only 26 characters
        if (str.length() > 26) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
}
