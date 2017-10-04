package com.maurofokker.test.arrays;

import com.maurofokker.test.utils.Tuple;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mauro on 10/3/17.
 */
public class MaximunSingleSellProfitTest {

    private MaximumSingleSellProfit maximumSingleSellProfit = new MaximumSingleSellProfit();

    @Test
    public void givenArrayWithDailyStocks_thenReturnBuyPriceSellPrice() {
        int[] array1 = {8, 5, 12, 9, 19, 1};
        Tuple<Integer, Integer> r1 = maximumSingleSellProfit.findBuySellStockPrices(array1);
        Tuple<Integer, Integer> expected1 = new Tuple<>(5, 19);

        int[] array2 = {21, 12, 11, 9, 6, 3};
        Tuple<Integer, Integer> r2 = maximumSingleSellProfit.findBuySellStockPrices(array2);
        Tuple<Integer, Integer> expected2 = new Tuple<>(12, 11);

        Assert.assertTrue(r1.equals(expected1));
        Assert.assertTrue(r2.equals(expected2));
    }
}
