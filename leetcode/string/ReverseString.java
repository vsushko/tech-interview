package string;

/**
 * 344. Reverse String
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 */
public class ReverseString {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s));
    }

    public static String reverseString(String s) {
        char[] array = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
        return String.valueOf(array);
    }
}
