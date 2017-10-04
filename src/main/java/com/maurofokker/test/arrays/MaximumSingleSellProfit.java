package com.maurofokker.test.arrays;

import com.maurofokker.test.utils.Tuple;

/**
 * Created by mauro on 10/3/17.
 *
 * Given a list of day stock prices (integers for simplicity), find the maximum single sell profit.
 *
 * i.e.
 *  array1 = {8, 5, 12, 9, 19, 1}
 *  return (5, 19)
 *
 *  array2 = {21, 12, 11, 9, 6, 3}
 *  return (12, 11)
 *
 *  return (buy, sell)
 *
 *
 *  Hint:
 *   - Kadane's algorithm
 *
 *  Linear solution O(n)
 *  Requires maintaining current buy price (which is the smallest number seen so far),
 *  current profit and global max profit as we iterate through the entire array of stock prices.
 *  At each iteration, we will compare the current profit with the global profit and update the global profit accordingly
 *
 *  Alternative solution O(n^2)
 *  FInd the maximum gain between each element and its succeeding elements.
 *
 *
 */
public class MaximumSingleSellProfit {

    /**
     * Runtime complexity O(n)
     * Memory complexity O(1)
     *
     * current profit = INT_MIN
     * current buy = stock_prices[0]
     * global sell = stock_prices[1]
     * global profit = global sell - current buy
     * For i = 1 to stock_prices.length:
     *   current profit = stock_prices[i] - current buy
     *   if current profit is greater than global profit
     *   then update global profit to current profit and update global sell to stock_prices[i]
     *   if stock_prices[i] is less than current buy then update current buy to stock_prices[i]
     * return global profit and global sell
     *
     * @param array}}
     * @return
     */
    public Tuple<Integer, Integer> findBuySellStockPrices(int[] array) {
        if(array == null || array.length < 2) {
            return null;
        }

        int currentBuy = array[0];
        int globalSell = array[1];
        int globalProfit = globalSell - currentBuy;

        int currentProfit = Integer.MIN_VALUE;

        for(int i=1 ; i < array.length ; i++) {
            currentProfit = array[i] - currentBuy;

            if(currentProfit > globalProfit) {
                globalProfit = currentProfit;
                globalSell = array[i];
            }

            if(currentBuy > array[i]) {
                currentBuy = array[i];
            }
        }

        Tuple<Integer,Integer> result =
                new Tuple<Integer,Integer>(
                        globalSell - globalProfit, //buy price
                        globalSell                  //sell price
                );

        return result;
    }

}
