package arrays;

/**
 * Task: How would you compute the parity of a very large number of 64-bit words?
 * Hint: Use a lookup table, but don't use 264 entries!
 */
public class Parity {
    public static void main(String[] args) {

    }

    /**
     * The time complexity is 0(n)
     *
     * @param x size of word
     * @return result
     */
    public static short bruteForceParity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    /**
     * Let k be the number of bits set to1in a particular word.
     * (For example, for 10001010, k = 3.)
     * Then time complexity of the algorithm above is0(k)
     *
     * @param x size of word
     * @return result
     */
    public static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;
            // drops the lowest set bit of x
            x &= (x - 1);
        }
        return result;
    }


}
