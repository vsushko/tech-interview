package easy;

/**
 * 796. Rotate String
 * <p>
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
 * For example, if A = 'abcde', then it will be 'bcdea' after one shift on A.
 * Return True if and only if A can become B after some number of shifts on A.
 */
public class RotateString {

    public static void main(String[] args) {
        String A = "abcde";
        String B = "cdeab";

        System.out.println(rotateString(A, B));

        A = "abcde";
        B = "abced";
        System.out.println(rotateString(A, B));

        A = "iqquydyvivwfvtgkfewecqlarygkqdxaejpfftuspeeomwvagnrdkozpztitulzxzuifmljudkjnzoeswjayjihpazilfcbpfhvv";
        B = "ydyvivwfvtgkfewecqlarygkqdxaejpfftuspeeomwvagnrdkozpztitulzxzuifmljudkjnzoeswjayjihpazilfcbpfhvviqqu";
        System.out.println(rotateString(A, B));

        A = "ohbrwzxvxe";
        B = "uornhegseo";
        System.out.println(rotateString(A, B));
    }

    // use binary search
    private static boolean rotateString(String A, String B) {
        int i = 0;

        while (i < A.length()) {
            if (A.charAt(i) == B.charAt(0)) {
                String temp = A.substring(i) + A.substring(0, i);
                if (temp.equals(B)) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}
