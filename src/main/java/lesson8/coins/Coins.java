package lesson8.coins;

import java.util.List;

public class Coins {

    public static void main(String[] args) {

        List<Integer> coins = List.of(1, 2, 5, 10);
        printCoins(coins, 100);
        printCoins(coins, 23);
    }

    public static void printCoins(List<Integer> coins, int sum) {
        for (int i = coins.size() - 1; i >= 0; i--) {
            Integer currentCoin = coins.get(i);
            while (sum >= currentCoin) {
                System.out.print(currentCoin + " ");
                sum -= currentCoin;
            }
        }
        System.out.println();
    }
}