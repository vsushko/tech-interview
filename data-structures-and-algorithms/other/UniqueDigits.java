package other;

import java.util.HashSet;
import java.util.Set;

public class UniqueDigits {

    public static void main(String[] args) {
        System.out.println(CountNumbersHavingUniqueDigitsWithSet(0, 999999));
        System.out.println(getUniqueDigitsCountWithRange(0, 999999));
    }

    private static int CountNumbersHavingUniqueDigitsWithSet(int min, int max) {
        int count = 0;

        for (int i = min; i <= max; i++) {
            if (checkUniqueDigits(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkUniqueDigits(int number) {
        int[] appearingDigits = new int[10];

        while (number > 0) {
            int digit = number % 10;
            appearingDigits[digit]++;
            number /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (appearingDigits[i] > 1) {
                return false;
            }
        }
        return true;
    }

    private static int getUniqueDigitsCountWithRange(int min, int max) {
        int count = 0;

        for (int i = 0; i < 999999; i++) {
            count += getUniqueDigitsCount(i);
        }
        return count;
    }

    private static int getUniqueDigitsCount(int number) {
        String numbers = String.valueOf(number);

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int i = 0; i < numbers.length(); i++) {
            int currentNumber = Character.getNumericValue(numbers.charAt(i));

            if (!uniqueNumbers.contains(currentNumber)) {
                uniqueNumbers.add(currentNumber);
            }
        }

        if (uniqueNumbers.size() == String.valueOf(number).length()) {
            return 1;
        }
        return 0;
    }

}
