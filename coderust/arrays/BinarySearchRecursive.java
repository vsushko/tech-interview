package arrays;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchRecursive {

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
        int index = binarySearch(array, 4);
        System.out.println(index);
    }

    private static int binarySearchRecursive(int[] a, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) / 2);

        if (a[mid] == key) {
            return mid;
        } else if (key < a[mid]) {
            return binarySearchRecursive(a, key, low, mid - 1);
        } else {
            return binarySearchRecursive(a, key, mid + 1, high);
        }
    }

    private static int binarySearch(int[] a, int key) {
        return binarySearchRecursive(a, key, 0, a.length);
    }
}
