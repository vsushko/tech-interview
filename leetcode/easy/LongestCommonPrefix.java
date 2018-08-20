package easy;

/**
 * 14. Longest Common Prefix
 *
 * @author vsushko
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] firstArray = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefixHS(firstArray));
        System.out.println(longestCommonPrefixVS(firstArray));
        System.out.println(longestCommonPrefixDC(firstArray));
        System.out.println(longestCommonPrefixBS(firstArray));
        // TODO: initialize the trie object
        // System.out.println(longestCommonPrefixTN(firstArray));

        String[] secondArray = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefixHS(secondArray));
        System.out.println(longestCommonPrefixVS(secondArray));
        System.out.println(longestCommonPrefixDC(secondArray));
        System.out.println(longestCommonPrefixBS(secondArray));
        // TODO: initialize the trie object
        //System.out.println(longestCommonPrefixTN(secondArray));
    }

    /**
     * Approach #1: Horizontal scanning
     * <p>
     * Time complexity: O(S), where S is the sum of all character in all strings
     * Space complexity: O(1), we only used constant extra space
     */
    private static String longestCommonPrefixHS(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * Approach #2: Vertical scanning
     * <p>
     * Time complexity: O(S), where s is the sum of all characters in all strings
     * Space complexity: O(1), we only used constant extra space
     */
    private static String longestCommonPrefixVS(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[i].length(); i++) {
            char c = strs[i].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * Approach #3: Divide and conquer
     * <p>
     * Time complexity: O(S), where S is the number of all characters in the array, S = m*n
     * Time complexity is 2*T(n/2)+O(m). Therefore time complexity is O(S), in the best case
     * algorithm performs O(minLen*n) comparisions, where minLen is the shortest string
     * of the array
     * Space complexity: O(m*log(n)) - there is a memory overhead since we store recursive calls
     * in the execution stack. There are log(n) recursive calls, each store need m space to
     * store the result, so space complexity is O(m*log(n))
     */
    private static String longestCommonPrefixDC(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefixDC(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefixDC(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefixDC(strs, l, mid);
            String lcpRight = longestCommonPrefixDC(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    /**
     * Approach #4: Binary search
     * <p>
     * Time complexity: O(S*log(n)), where S is the sum of all Characters in all strings
     * The algorithm makes log(n) iterations, for each of them there are S = m*n comparisons,
     * which gives in total O(S*log(n)) time complexity
     * Space complexity: O(1), we only used constant extra space
     */
    private static String longestCommonPrefixBS(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;

        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach #5: LCP queries optimization by storing the set of keys S in a Trie
     * <p>
     * In the worst case query q has length m and it is equal to all strings of the array
     * <p>
     * Time complexity: preprocessing O(S), where S is the number
     * of all characters in the array, LCP query O(m)
     * Trie build has O(S) time complexity. To find the common prefix of q in the Trie
     * takes in the worst case O(m)
     * Space complexity: O(S), we only used additional S extra space for the Trie
     */
    private static String longestCommonPrefixTN(String q, String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Trie trie = new Trie();
        for (int i = 1; i < strs.length; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(q);
    }

}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public String searchLongestPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
                prefix.append(curLetter);
                node = node.get(curLetter);
            } else
                return prefix.toString();

        }
        return prefix.toString();
    }
}

class TrieNode {
    // R links to node children
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    // number of children non null links
    private int size;

    public int getLinks() {
        return size;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}