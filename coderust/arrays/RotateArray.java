package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {

    public static void main(String[] args) {

        // solution 1
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        for (Integer el : array) {
            System.out.print(el + ", ");
        }
        System.out.println();

        rotateArrayInPlace(array, 2);

        for (Integer el : array) {
            System.out.print(el + ", ");
        }
        System.out.println();

        // solution 2
        List<Integer> array2 = new ArrayList<>(Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40));

        for (Integer el : array2) {
            System.out.print(el + ", ");
        }
        System.out.println();

        rotateArrayInPlace(array2, -3);

        for (Integer el : array2) {
            System.out.print(el + ", ");
        }
    }

    private static void reverseArray(List<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            ++start;
            --end;
        }
    }

    static void rotateArrayInPlace(List<Integer> arr, int n) {
        int len = arr.size();
        // let's normalize rotations
        // if n > array size or n is negative
        n = n % len;

        if (n < 0) {
            // calculate the positive rotations needed
            n = n + len;
        }
        // let's partition the array based on rotations 'n'
        // for example: 1, 2, 3, 4, 5 where n = 2
        // -> 5, 4, 3, 2, 1
        // -> 4, 5, 3, 2, 1
        // -> 4, 5, 1, 2, 3
        reverseArray(arr, 0, len - 1);
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, n, len - 1);
    }

    private static void rorateAray(List<Integer> arr, int n) {
        int len = arr.size();
        // let's normalize rotations
        // if n > array size or n is negative
        n = n % len;
        if (n < 0) {
            // calculate the positive rotations needed
            n = n + len;
        }
        List<Integer> temp = Arrays.asList(new Integer[n]);

        // copy last N elements of array into temp
        for (int i = 0; i < n; i++) {
            temp.set(i, arr.get(len - n + i));
        }
        // shift original array
        for (int i = len - 1; i >= n; i--) {
            arr.set(i, arr.get(i - n));
        }
        // copy temp into original array
        for (int i = 0; i < n; i++) {
            arr.set(i, temp.get(i));
        }
    }

}
