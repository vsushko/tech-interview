package arrays;

public class ImplementQuicksort {

    public static void main(String[] args) {
        int[] array = new int[]{55, 23, 26, 2, 25};

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();

        quickSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotValue = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivotValue) {
                i++;
            }
            while (arr[j] > pivotValue) {
                j--;
            }
            if (i < j) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                break;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivotValue;

        // return the pivot index
        return j;
    }

    // Hoar's algorithm
    private static void quickSortRec(int[] arr, int low, int high) {
        if (high > low) {
            int pivotIndex = partition(arr, low, high);

            quickSortRec(arr, low, pivotIndex - 1);
            quickSortRec(arr, pivotIndex + 1, high);
        }
    }

    static void quickSort(int[] arr) {
        quickSortRec(arr, 0, arr.length - 1);
    }
}
