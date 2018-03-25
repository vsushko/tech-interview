package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. Unique Morse Code Words
 * <p>
 * International Morse Code defines a standard encoding where each
 * letter is mapped to a series of dots and dashes, as follows:
 * "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English
 * alphabet is given below:
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
 * ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
 * ".--","-..-","-.--","--.."]
 * <p>
 * Now, given a list of words, each word can be written as a concatenation
 * of the Morse code of each letter. For example, "cab" can be written as
 * "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-").
 * We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 */
public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] alphabet = new String[]{".-", "-...", "-.-.", "-..", ".",
                "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> convertedWords = new HashSet<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : word.toCharArray()) {
                stringBuilder.append(alphabet[c - 'a']);
            }
            convertedWords.add(stringBuilder.toString());
        }
        return convertedWords.size();
    }
}
