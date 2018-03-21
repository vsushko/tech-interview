package hashtable;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

    public static int numJewelsInStones(String J, String S) {
        Map<Character, Integer> table = new HashMap<>();

        for (int i = 0; i < J.length(); i++) {
            char key = J.charAt(i);
            if (!table.containsKey(key)) {
                table.put(key, 0);
            }
        }

        for (int i = 0; i < S.length(); i++) {
            char key = S.charAt(i);
            if (table.containsKey(key)) {
                int count = table.getOrDefault(key, 0);
                table.put(key, count + 1);
            }
        }

        int result = 0;

        for (Character key : table.keySet()) {
            result += table.get(key);
        }
        return result;
    }
}
