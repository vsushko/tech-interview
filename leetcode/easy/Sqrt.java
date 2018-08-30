package easy;

/**
 * 69. Sqrt(x)
 *
 * @author vsushko
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println("2=" + mySqrt(4));
        System.out.println("2=" + mySqrt(8));
        System.out.println("1=" + mySqrt(1));
        System.out.println("32=" + mySqrt(1024));
    }

    private static int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int low = 1;
        int high = x;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (x / mid == mid) {
                return mid;
            }
            if (x / mid < mid) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }
}
