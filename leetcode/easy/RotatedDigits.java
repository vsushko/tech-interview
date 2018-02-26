package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X.
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate
 * to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other,
 * and the rest of the numbers do not rotate to any other number.
 */
public class RotatedDigits {

    public static void main(String[] args) {
        int number = 857;
        System.out.println(rotatedDigits(number));
    }

    public static int rotatedDigits(int N) {
        Set<Integer> rotatedNumbers = new HashSet<>();

        for (int i = 1; i <= N; i++) {

            char[] numbers = Integer.toString(i).toCharArray();
            List<Integer> afterRotation = new ArrayList<>();

            for (int j = 0; j < numbers.length; j++) {

                int numericValue = Character.getNumericValue(numbers[j]);

                switch (numericValue) {
                    case 0:
                        if (N > 10) {
                            afterRotation.add(ROTATED_NUMBER.ZERO.getNumber());
                        }
                        break;
                    case 1:
                        if (N > 10) {
                            afterRotation.add(ROTATED_NUMBER.ONE.getNumber());
                        }
                        break;
                    case 8:
                        if (N > 10) {
                            afterRotation.add(ROTATED_NUMBER.EIGHT.getNumber());
                        }
                        break;
                    case 2:
                        afterRotation.add(ROTATED_NUMBER.TWO.getNumber());
                        break;
                    case 5:
                        afterRotation.add(ROTATED_NUMBER.FIVE.getNumber());
                        break;
                    case 6:
                        afterRotation.add(ROTATED_NUMBER.SIX.getNumber());
                        break;
                    case 9:
                        afterRotation.add(ROTATED_NUMBER.NINE.getNumber());
                        break;
                    default:
                        break;
                }
            }
            int initialNumber = Integer.valueOf(String.valueOf(numbers));
            Integer rotatedNumber = getNumber(afterRotation);

            if (rotatedNumber != null
                    && String.valueOf(initialNumber).length() == String.valueOf(rotatedNumber).length()
                    && initialNumber != rotatedNumber) {
                //System.out.println(initialNumber + "->" + rotatedNumber);
                rotatedNumbers.add(rotatedNumber);
            }
        }
        return rotatedNumbers.size();
    }

    private static Integer getNumber(List<Integer> array) {
        if (array.isEmpty()) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int anArray : array) {
            builder.append(anArray);
        }

        return Integer.valueOf(builder.toString());
    }

    enum ROTATED_NUMBER {
        ZERO(0),
        ONE(1),
        EIGHT(8),
        TWO(5),
        FIVE(2),
        SIX(9),
        NINE(6);

        private int number;

        ROTATED_NUMBER(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }
}
