package arrays;

public class MoveZerosToLeft {

    public static void main(String[] args) {
        int[] array = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};

        for (int elem : array) {
            System.out.print(elem + ", ");
        }
        System.out.println();

        moveZerosToLeftInArray(array);

        for (int elem : array) {
            System.out.print(elem + ", ");
        }
    }

    private static void moveZerosToLeftInArray(int[] A) {
        if (A == null) {
            return;
        }

        int writeIndex = A.length - 1;
        int readIndex = A.length - 1;

        while (readIndex >= 0) {
            if (A[readIndex] != 0) {
                A[writeIndex] = A[readIndex];
                writeIndex--;
            }
            readIndex--;
        }

        while (writeIndex >= 0) {
            A[writeIndex] = 0;
            writeIndex--;
        }
    }
}
