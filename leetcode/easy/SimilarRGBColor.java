package easy;

/**
 * 800. Similar RGB Color
 * <p>
 * In the following, every capital letter represents some hexadecimal digit from 0 to f.
 * <p>
 * The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example,
 * "#15c" is shorthand for the color "#1155cc".
 * <p>
 * Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
 * <p>
 * Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF,
 * and has a shorthand (that is, it can be represented as some "#XYZ"
 */
public class SimilarRGBColor {

    public static void main(String[] args) {
        String input = "09f166";
        System.out.println(similarRGB(input));
    }

    private static String checkForSimilarity(char firstChar, char secondChar) {
        String result = "";
        String dict = "0123456789abcdef";

        int firstIndex = dict.indexOf(firstChar);
        int secondIndex = dict.indexOf(secondChar);

        int min = Math.abs(secondIndex - firstIndex);
        int index = firstIndex;
        if (firstIndex + 1 <= 15) {
            int abs = Math.abs((firstIndex + 1) * 15 + firstIndex + 1 - (firstIndex * 15 + secondIndex));
            if (abs < min) {
                index = firstIndex + 1;
            }
        }
        if (firstIndex - 1 >= 0) {
            int abs = Math.abs((firstIndex - 1) * 15 + firstIndex - 1 - (firstIndex * 15 + secondIndex));
            if (abs < min) {
                index = firstIndex - 1;
            }
        }
        result += dict.charAt(index);
        result += dict.charAt(index);

        return result;
    }

    public static String similarRGB(String input) {
        StringBuilder result = new StringBuilder("#");

        for (int i = 0; i < input.toCharArray().length; i += 2) {
            char firstChar = input.charAt(i);
            char secondChar = input.charAt(i + 1);
            result.append(checkForSimilarity(firstChar, secondChar));
        }

        return result.toString();
    }
}
