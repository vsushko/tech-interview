package orbita;

import java.util.*;

/**
 * @author vsuhko
 */
public class LoginSuggestions {

    private static Map<String, Integer> repo = new HashMap<>();

    public static void main(String[] args) {
        Collection<String> namesList =
                Arrays.asList("ffdse3e5", "aba3ab", "aba3ab", "asdf2", "aba3ab", "ffdse3e5", "aba3ab");
        Collection<String> suggestedNames = generateSuggestions(namesList);

        for (String suggestedName : suggestedNames) {
            System.out.println(suggestedName);
        }
    }

    private static Collection<String> generateSuggestions(Collection<String> strings) {
        Set<String> suggestions = new LinkedHashSet<>();

        for (String name : strings) {
            if (repo.containsKey(name)) {
                int count = repo.get(name) + 1;
                repo.put(name, count);
                String suggestedName = name + "" + count;
                // System.out.println("name: " + suggestedName + ", count: " + count);
                suggestions.add(suggestedName);
            } else {
                repo.put(name, 1);
                // System.out.println("name: " + name + 1 + ", count: " + 1);
            }
        }
        return suggestions;
    }

}
