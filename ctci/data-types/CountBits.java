package arrays;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(countBits(12345));
    }

    /**
     * Count the number of bits that are set to 1
     * perform 0(1) computation per bit
     * the time complexity is 0(n)
     *
     * @param x integer
     * @return numBits
     */
    private static short countBits(int x) {
        short numBits = 0;

        while (x != 0) {
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }
}
