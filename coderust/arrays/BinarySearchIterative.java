package arrays;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchIterative {

    private static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = rand.ints(ARRAY_SIZE, 0, ARRAY_SIZE + 1).toArray();

        for (int anArray : array) {
            System.out.print(anArray + " ");
        }

        Arrays.sort(array);
        System.out.println();

        for (int anArray : array) {
            System.out.print(anArray + " ");
        }

        System.out.println();
        int index = binarySearchIterative(array, 4);
        System.out.println(index);
    }

    private static int binarySearchIterative(int[] A, int key) {
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (A[mid] == key) {
                return mid;
            }

            if (key < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
