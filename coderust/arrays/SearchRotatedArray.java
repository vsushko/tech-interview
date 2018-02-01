package arrays;

public class SearchRotatedArray {

    public static void main(String[] args) {
        int[] array = new int[]{
                76, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59,
                63, 75, 88, 99, 107, 120, 133, 155, 162};
        System.out.println(binarySearchRotated(array, 200));
    }

    private static int binarySearch(int[] arr, int st, int end, int key) {
        // assuming all the keys are unique.

        if (st > end) {
            return -1;
        }

        int mid = st + (end - st) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[st] < arr[mid] && key < arr[mid] && key >= arr[st]) {
            return binarySearch(arr, st, mid - 1, key);
        } else if (arr[mid] < arr[end] && key > arr[mid] && key <= arr[end]) {
            return binarySearch(arr, mid + 1, end, key);
        } else if (arr[st] > arr[mid]) {
            return binarySearch(arr, st, mid - 1, key);
        } else if (arr[end] < arr[mid]) {
            return binarySearch(arr, mid + 1, end, key);
        }
        return -1;
    }

    private static int binarySearchRotated(int[] arr, int key) {
        return binarySearch(arr, 0, arr.length - 1, key);
    }
}