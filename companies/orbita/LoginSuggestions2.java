package orbita;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vsuhko
 */
public class LoginSuggestions2 {
    private static Map<String, Integer> repo = new HashMap<>();

    public static void main(String[] args) {
        // generates new suggestions
        generateSuggestions(Arrays.asList("ffdse3e5", "aba3ab", "aba3ab",
                "asdf2", "aba3ab", "ffdse3e5", "aba3ab"));
        // print
        repo.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
    }

    private static void generateSuggestions(Collection<String> strings) {
        for (String name : strings) {
            int count = repo.getOrDefault(name, 0) + 1;
            repo.put(name, count);
        }
    }
}
