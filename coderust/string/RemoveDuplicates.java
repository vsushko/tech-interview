package string;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        String test = "abbabcddbabcdeedebc\0";
        System.out.println(removeDuplicates1(test.toCharArray()));
        System.out.println(removeDuplicates2(test.toCharArray()));
    }

    // this solution uses extra memory
    // to keep all characters present in string
    // Null terminating strings are not used in Java.
    // For this question, assume that you are passed a
    // null terminated string (array of characters)
    private static Set<Character> removeDuplicates1(char[] str) {
        Set<Character> hashSet = new LinkedHashSet<>();

        int writeIndex = 0;
        int readIndex = 0;

        while (str[readIndex] != '\0') {
            if (!hashSet.contains(str[readIndex])) {
                hashSet.add(str[readIndex]);
                str[writeIndex] = str[readIndex];
                ++writeIndex;
            }
            ++readIndex;
        }
        str[writeIndex] = '\0';

        return hashSet;
    }


    private static char[] removeDuplicates2(char[] str) {
        // this solution does not require any extra memory but runs in O(n^2)

        // Null terminating string are not used in Java. For this question,
        // assume that you are passed a null terminated string (array of characters).
        if (str == null || str.length == 0) {
            return new char[]{};
        }

        int writeIndex = 0;
        
        for (int i = 0; i < str.length; i++) {
            boolean found = false;

            for (int j = 0; j < writeIndex; j++) {
                if (str[i] == str[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                str[writeIndex] = str[i];
                writeIndex++;
            }
        }
        str[writeIndex] = '\0';
        return str;
    }
}