import java.util.Scanner;

/**
 * Created by vsushko on 01.11.2017
 */
public class Solution {

    static int solveMeFirst(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int sum = solveMeFirst(a, b);
        System.out.println(sum);
    }
}
