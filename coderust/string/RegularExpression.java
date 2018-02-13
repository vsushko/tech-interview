package string;

public class RegularExpression {

    public static void main(String[] args) {
        String text = "aabbbbbcdda";
        System.out.println("Text: " + text);
        System.out.println("Matching Patterns:");
        String pattern = "a*bb*cdda";
        System.out.println("Pattern: " + pattern + ": " + regxMatch(text, pattern));
        pattern = "a*bb*.dda";
        System.out.println("Pattern: " + pattern + ": " + regxMatch(text, pattern));
        pattern = "aab*e*cd*a";
        System.out.println("Pattern: " + pattern + ": " + regxMatch(text, pattern));
        pattern = "a*b*c*d*a*";
        System.out.println("Pattern: " + pattern + ": " + regxMatch(text, pattern));
        pattern = ".*b*c*d*a*";
        System.out.println("Pattern: " + pattern + ": " + regxMatch(text, pattern));
        pattern = "aabbbbbcdda";
        System.out.println("Pattern: " + pattern + ": " + regxMatch(text, pattern));
        System.out.println("Non-Matching Patterns:");
        pattern = "aabbbbbcdd";
        System.out.println("Pattern: " + pattern + ": " + regxMatch(text, pattern));
        pattern = "a*b*c*da";
        System.out.println("Pattern: " + pattern + ": " + regxMatch(text, pattern));
    }

    private static boolean regxMatchRec(String text, String pattern) {
        if (text.isEmpty() && pattern.isEmpty()) {
            return true;
        }

        if (!text.isEmpty() && pattern.isEmpty()) {
            return false;
        }

        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            String remainingPattern = pattern.substring(2);
            String remainingText = text;

            for (int i = 0; i < text.length() + 1; i++) {
                if (regxMatchRec(remainingText, remainingPattern)) {
                    return true;
                }
                if (remainingText.isEmpty()) {
                    return false;
                }
                if (pattern.charAt(0) != '.' && remainingText.charAt(0) != pattern.charAt(0)) {
                    return false;
                }
                remainingText = remainingText.substring(1);
            }
        }
        if (text.isEmpty() || pattern.isEmpty()) {
            return false;
        }
        if (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
            String remainingText = "";
            if (text.length() >= 2) {
                remainingText = text.substring(1);
            }
            String remainingPattern = "";
            if (pattern.length() >= 2) {
                remainingPattern = pattern.substring(1);
            }
            return regxMatchRec(remainingText, remainingPattern);
        }
        return false;
    }

    static boolean regxMatch(String text, String pattern) {
        return regxMatchRec(text, pattern);
    }

    private static boolean match(String text, String pattern, int i, int j) {
        if (text.length() == i && pattern.length() == j) {
            return true;
        }
        if (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
            for (int k = i; k <= text.length(); k++) {
                if (match(text, pattern, k, j + 2)) {
                    return true;
                }
                if (k >= text.length()) {
                    return false;
                }
                if (pattern.charAt(j) != '.' && text.charAt(k) != pattern.charAt(j)) {
                    return false;
                }
            }
        } else if (i < text.length() && j < pattern.length()
                && (pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i))) {
            return match(text, pattern, i + 1, j + 1);
        }
        return false;
    }

    public static boolean match(String text, String pattern) {
        return match(text, pattern, 0, 0);
    }
}
