package arrays;

public class FindSmallestCommonNumber {

    public static void main(String[] args) {

        int[] arr1 = new int[]{6, 7, 10, 25, 30, 63, 64};
        int[] arr2 = new int[]{-1, 4, 5, 6, 7, 8, 50};
        int[] arr3 = new int[]{1, 6, 10, 14};

        System.out.println(findLeastCommonNumber(arr1, arr2, arr3));
    }

    private static int findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {

            // found the smallest common number
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                return arr1[i];
            }
            // let's advance the iterator for the smallest value
            if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
                i++;
            } else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
                j++;
            } else if (arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
                k++;
            }
        }
        return -1;
    }
}

