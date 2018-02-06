package arrays;

import javafx.util.Pair;

public class FindMaximumSingleSellProfit {

    public static void main(String[] args) {
        int[] array = new int[]{12, 5, 9, 19};
        System.out.println(findBuySellStockPrices(array));
    }

    private static Pair<Integer, Integer> findBuySellStockPrices(int[] array) {

        if (array == null || array.length < 2) {
            return null;
        }

        int currentBuy = array[0];
        int globalSell = array[1];
        int globalProfit = globalSell - currentBuy;

        int currentProfit = Integer.MIN_VALUE;

        for (int i = 1; i < array.length; i++) {
            currentProfit = array[i] - currentBuy;

            if (currentProfit > globalProfit) {
                globalProfit = currentProfit;
                globalSell = array[i];
            }
            if (currentBuy > array[i]) {
                currentBuy = array[i];
            }
        }
        // (buy price, sell price)
        Pair<Integer, Integer> result = new Pair<>(globalSell - globalProfit, globalSell);
        return result;
    }
}