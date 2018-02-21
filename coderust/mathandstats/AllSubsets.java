package mathandstats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Find all subsets of a given set of integers.
 * <p>
 * Runtime Complexity: Exponential, O(2n) - where 'n' is
 * number of integers in the given set.
 * Memory Complexity: Constant, O(1)
 */
public class AllSubsets {

    public static void main(String[] args) {
        List<Integer> v = new ArrayList<>(Arrays.asList(2, 3, 4));
        List<HashSet<Integer>> sets = new ArrayList<>();
        getAllSubsets(v, sets);
        for (HashSet<Integer> set : sets) {
            System.out.print(set + ", ");
        }
    }

    private static int getBit(int num, int bit) {
        int temp = (1 << bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }

    private static void getAllSubsets(List<Integer> v, List<HashSet<Integer>> sets) {
        int subsetsCount = (int) (Math.pow((double) 2, (double) v.size()));
        for (int i = 0; i < subsetsCount; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < v.size(); j++) {
                if (getBit(i, j) == 1) {
                    int x = v.get(j);
                    set.add(x);
                }
            }
            sets.add(set);
        }
    }
}
