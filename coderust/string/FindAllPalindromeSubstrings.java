package string;

public class FindAllPalindromeSubstrings {

    public static void main(String[] args) {
        String test = "aabbbaa";
        findAllPalindromeSubstrings(test);
    }

    private static boolean isPalindrome(String input, int i, int j) {
        while (j > i) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static int findAllPalindromeSubstrings(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (isPalindrome(input, i, j)) {
                    System.out.println(input.substring(i, j + 1));
                    count++;
                }
            }
        }
        return count;
    }
}
