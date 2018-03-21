package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * <p>
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number
 * and for the multiples of five output “Buzz”. For numbers which are
 * multiples of both three and five output “FizzBuzz”.
 */
public class FizzBuzz {

    public static void main(String[] args) {
        int n = 1;
        List<String> strings = fizzBuzz(n);

        for (String s : strings) {
            System.out.println(s);
        }
    }

    public static List<String> fizzBuzz(int n) {
        List<String> strings = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                strings.add("FizzBuzz");
            } else if (i % 3 == 0) {
                strings.add("Fizz");
            } else if (i % 5 == 0) {
                strings.add("Buzz");
            } else {
                strings.add(String.valueOf(i));
            }
        }
        return strings;
    }

}
