package backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of N positive integers, find all the subsets of
 * the given array that sum up to the number K.
 * <p>
 * Solution 1
 * Runtime Complexity
 * Exponential, O(2^n) - where 'n' is number of integers in the given set.
 * Memory Complexity: Constant, O(1)
 * <p>
 * Solution 2
 * Runtime Complexity:
 * Exponential, O(2n) - where 'n' is number of integers in the given set.
 * Memory Complexity: Logarithmic, O(logn).
 * Recursive solution has O(logn) memory complexity as it will consume memory on the stack.
 */
public class FindKSumSubsets {

    public static void main(String[] args) {

    }

    private static int getBit(int num, int bit) {
        int temp = (1 << bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }

    private static void getKSumSubsets1(List<Integer> v, Integer targetSum,
                                        List<Set<Integer>> sets) {
        int subsetsCount = (int) (Math.pow((double) 2, (double) v.size()));
        for (int i = 0; i < subsetsCount; i++) {
            Set<Integer> set = new HashSet<>();
            Integer sum = 0;

            for (int j = 0; j < v.size(); j++) {
                if (getBit(i, j) == 1) {
                    sum += v.get(j);
                    if (sum > targetSum) {
                        break;
                    }
                    set.add(v.get(j));
                }
            }
            if (sum.equals(targetSum)) {
                sets.add(set);
            }
        }
    }

    // solution in python
    // get_k_sum_subsets_2
    /* def get_k_sum_subsets_rec(list, partial_list,target_sum,sets):
    list_sum = sum(partial_list)
  	if (list_sum == target_sum and len(partial_list) > 0):
            sets.append(partial_list)
    elif list_sum > target_sum:
            return
            else:
            for i in xrange(0, len(list)):
    new_partial_list = partial_list[0:]
            new_partial_list.append(list[i])

    new_list = list[i+1:]

    get_k_sum_subsets_rec(new_list,new_partial_list, target_sum,sets)

    def get_k_sum_subsets_2(list, target_sum, sets):
    partial_list = []
    get_k_sum_subsets_rec(list,partial_list,target_sum,sets)*/
}
