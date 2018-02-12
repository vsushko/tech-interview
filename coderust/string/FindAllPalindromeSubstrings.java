package string;

public class FindAllPalindromeSubstrings {

    public static void main(String[] args) {
        String test = "aabbbaa";
        System.out.println(findAllPalindromeSubstrings(test));
        System.out.println(findAllPalindromeSubstrings2(test));
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
                    System.out.print(input.substring(i, j + 1) + ", ");
                    count++;
                }
            }
        }
        System.out.println();
        return count;
    }

    private static int findPalindromesInSubString(String input, int j, int k) {
        int count = 0;

        for (; j >= 0 && k < input.length(); --j, ++k) {
            if (input.charAt(j) != input.charAt(k)) {
                break;
            }
            System.out.print(input.substring(j, k + 1) + ", ");
            count++;
        }
        return count;
    }

    private static int findAllPalindromeSubstrings2(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count += findPalindromesInSubString(input, i - 1, i + 1);
            count += findPalindromesInSubString(input, i, i + 1);
        }
        System.out.println();
        return count;
    }
}
