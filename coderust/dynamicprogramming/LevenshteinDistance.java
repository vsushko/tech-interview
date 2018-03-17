package dynamicprogramming;

/**
 * Compute Levenshtein distance between two strings.
 * <p>
 * Solution #1
 * Runtime Complexity: Quadratic, O(n2)
 * Memory Complexity: Quadratic, O(n2)
 * <p>
 * Solution #2
 * Runtime Complexity: Quadratic, O(n2)
 * Memory Complexity: Linear, O(n)
 */
public class LevenshteinDistance {

    public static void main(String[] args) {
        String s1 = "kitten";
        String s2 = "sitting";
        System.out.println(computeLevenshteinDistance(s1, s2));
        System.out.println(computeLevenshteinDistance2(s1, s2));
    }

    private static int computeLevenshteinDistance(String str1, String str2) {

        //degenerate cases
        if (str1.equals(str2))
            return 0;

        if (str1.length() == 0)
            return str2.length();

        if (str2.length() == 0)
            return str1.length();

        // for all i and j, d[i,j] will hold the Levenshtein distance between
        // the first i characters of str1 and the first j characters of str2;
        // note that d has (m+1)*(n+1) values
        int[][] d = new int[str1.length() + 1][str2.length() + 1];

        // source prefixes can be transformed into empty string by
        // dropping all characters
        for (int i = 0; i <= str1.length(); i++) {
            d[i][0] = i;
        }

        // target prefixes can be reached from empty source prefix
        // by inserting every character
        for (int j = 1; j <= str2.length(); j++) {
            d[0][j] = j;
        }

        int cost;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    cost = 0;    // no operation required
                else
                    cost = 1;

                d[i][j] = minimum(
                        d[i - 1][j] + 1,    // a deletion
                        d[i][j - 1] + 1,    // an insertion
                        d[i - 1][j - 1] + cost); // a substitution
            }
        }

        return d[str1.length()][str2.length()];
    }

    public static int computeLevenshteinDistance2(String str1, String str2) {

        //degenerate cases
        if (str1.equals(str2))
            return 0;

        if (str1.length() == 0)
            return str2.length();

        if (str2.length() == 0)
            return str1.length();

        // create two work arrays of integer distances
        int[] d1 = new int[str2.length() + 1];
        int[] d2 = new int[str2.length() + 1];

        // initialize d1 (the previous row of distances)
        // this row is A[0][i]: edit distance for an empty str1
        // the distance is just the number of characters to delete from str2
        for (int i = 0; i < d1.length; i++)
            d1[i] = i;

        int cost;
        for (int i = 0; i < str1.length(); i++) {

            // calculate d2 (current row distances) from the previous row d1

            // first element of d2 is A[i+1][0]
            // edit distance is delete (i+1) chars from str1 to match empty str2
            d2[0] = i + 1;

            // use formula to fill in the rest of the row
            for (int j = 0; j < str2.length(); j++) {

                if (str1.charAt(i) == str2.charAt(j))
                    cost = 0;
                else
                    cost = 1;

                d2[j + 1] = minimum(d2[j] + 1, d1[j + 1] + 1, d1[j] + cost);
            }

            // copy d2(current row) to d1(previous row) for next iteration
            for (int j = 0; j < d1.length; j++)
                d1[j] = d2[j];
        }

        return d2[str2.length()];
    }

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
