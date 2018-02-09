package honorsclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindElementAppearsOnce {
    // @include
    public static int findElementAppearsOnce(List<Integer> A) {
        int[] counts = new int[32];
        for (int x : A) {
            for (int i = 0; i < 32; ++i) {
                counts[i] += x & 1;
                x >>= 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result |= (counts[i] % 3) << i;
        }
        return result;
    }
    // @exclude

    private static int findElementAppearsOnceAlternative(List<Integer> A) {
        // ones denotes whether a bit-position has been set once (modulo 3) so far.
        // twos denotes whether a bit-position has been set twice (modulo 3) so far.
        int ones = 0, twos = 0;
        int nextOnes, nextTwos;
        for (int i : A) {
            // After reading A.get(i), bit-position j has a count of 1 modulo 3
            // if it had a count of 1 modulo 3 (the j-th bit in ones is set)
            // and the j-th bit in A.get(i) is 0 or the count was 0 modulo 3
            // (the j-th bit is not set in ones and in not set in twos) and
            // the j-th bit in A.get(i) is 1.
            nextOnes = (~i & ones) | (i & ~ones & ~twos);

            // After reading A.get(i), bit-position j has a count of 2 modulo 3
            // if it had a count of 2 modulo 3 (the j-th bit in twos is set)
            // and the j-th bit in A.get(i) is a 0 or the count was 1 modulo 3
            // (the j-th bit is set in ones) and the j-th bit in A.get(i) is a 1.
            nextTwos = (~i & twos) | (i & ones);

            ones = nextOnes;
            twos = nextTwos;
        }
        // Since ones denotes bit-positions which have been set once (modulo 3),
        // it is the element which appears only once.
        return ones;
    }

    private static void test() {
        List<Integer> A = Arrays.asList(-2, -2, 1, 1, -3, 1, -3, -3, -4, -2);
        assert (findElementAppearsOnce(A) == -4);
        assert (findElementAppearsOnceAlternative(A) == -4);
    }

    public static void main(String[] args) {
        test();
        Random r = new Random();
        for (int times = 0; times < 10000; ++times) {
            int n;
            if (args.length == 1) {
                n = Integer.parseInt(args[0]);
            } else {
                n = r.nextInt(10000) + 1;
            }
            List<Integer> A = new ArrayList<>(3 * (n - 1) + 1);
            int single = r.nextInt(2 * n) - n;
            int idx = 0;
            for (int i = -n; i < n; ++i) {
                A.add(i);
                if (i != single) {
                    A.add(i);
                    A.add(i);
                }
            }
            System.out.println("Singleton element: " + findElementAppearsOnce(A));
            assert (findElementAppearsOnce(A) == single);
            assert (findElementAppearsOnce(A) == findElementAppearsOnceAlternative(A));
        }
    }
}
