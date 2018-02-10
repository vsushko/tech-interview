package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringSegmentation {

    public static void main(String[] args) {
        String s1 = "applepie";
        Set<String> dict1 = new HashSet<>(Arrays.asList("apple", "pear", "pier", "pie"));
        System.out.println("For string [" + s1 + "] - " + canSegmentString(s1, dict1));
        s1 = "applepeer";
        System.out.println("For string [" + s1 + "] - " + canSegmentString(s1, dict1));

        String s2 = "hellonow";
        Set<String> dict2 = new HashSet<>(Arrays.asList("hello", "hell", "on", "now"));
        System.out.println("For string [" + s2 + "] - " + canSegmentString(s2, dict2));
    }

    private static boolean canSegmentString(String s, Set<String> dict) {
        Set<String> solved = new HashSet<>();
        return canSegmentString(s, dict, solved);
    }

    private static boolean canSegmentString(String s, Set<String> dict, Set<String> solved) {
        for (int i = 1; i <= s.length(); i++) {
            String first = s.substring(0, i);

            if (dict.contains(first)) {
                String second = s.substring(i);

                if (second == null || second.length() == 0 || dict.contains(second)) {
                    return true;
                }
                if (!solved.contains(second)) {
                    if (canSegmentString(second, dict, solved)) {
                        return true;
                    }
                    solved.add(second);
                }
            }
        }
        return false;
    }
}
