package arrays;

import java.util.ArrayDeque;
import java.util.Random;

public class FindMaxSlidingWindow {

    private static final int ARRAY_SIZE = 20;

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = rand.ints(ARRAY_SIZE, -10, ARRAY_SIZE + 1).toArray();

        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println();
        findMaxSlidingWindow(array, 3);
    }

    private static void findMaxSlidingWindow(int[] array, int windowSize) {
        if (array.length < windowSize) {
            return;
        }

        ArrayDeque<Integer> window = new ArrayDeque<>();

        // find out max for the first window
        for (int i = 0; i < windowSize; i++) {
            while (!window.isEmpty() && array[i] >= array[window.peekLast()]) {
                window.removeLast();
            }
            window.addLast(i);
        }

        System.out.print(array[window.peekFirst()] + ", ");

        for (int i = windowSize; i < array.length; i++) {
            // remove all numbers that are smaller than current number
            // from the tail of queue
            while (!window.isEmpty() && array[i] >= array[window.peekLast()]) {
                window.removeLast();
            }
            if (!window.isEmpty() && window.peekFirst() <= i - windowSize) {
                window.removeFirst();
            }
            window.addLast(i);
            System.out.print(array[window.peekFirst()] + ", ");
        }
    }
}