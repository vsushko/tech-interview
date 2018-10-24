package gazprombank;

import java.util.Random;

/**
 * @author vsushko
 */
public class Dice {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3};
        System.out.println(getRandom(arr));
        System.out.println(getRandom(arr));
        System.out.println(getRandom(arr));
        System.out.println(getRandom(arr));
    }

    private static int getRandom(int[] arr) {
        return arr[2 * dice() + dice()];
    }

    private static int dice() {
        Random rand = new Random();
        return rand.nextInt(2);
    }
}
