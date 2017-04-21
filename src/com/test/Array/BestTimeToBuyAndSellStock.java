package com.test.Array;

import java.util.Arrays;

/**
 * Created by Kaijia Wei on 2017/4/19.
 */
public class BestTimeToBuyAndSellStock {

    /**
     *  Say you have an array for which the ith element is the price of a given stock on day i.
     *  Design an algorithm to find the maximum profit. You may complete as many transactions as you like
     *  (ie, buy one and sell one share of the stock multiple times).
     *  However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     *  tags ： 数组  贪心算法
     */
    public int maxProfit(int[] prices){
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i+1] > prices[i]) total += prices[i+1] - prices[i];
        }
        return total;
    }

    /**
     *
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction
     * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     *  tags : 数组 动态规划
     */
    public int maxProfitI(int[] prices){
        if (prices == null || prices.length==0){
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i <= prices.length; i++){
            if (prices[i] < min ) {
                min = prices[i];
            }else{
                if(prices[i] - min > profit){
                    profit = prices[i] - min;
                }
            }
        }
        return profit;
    }

    public int maxProfitII(int[] prices){
        if (prices == null || prices.length==0){
            return 0;
        }
        int maxCur = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            maxCur = Math.max(0,maxCur+=prices[i] - prices[i-1]);
            profit = Math.max(profit,maxCur);
        }
        return profit;
    }

    /**
     *
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * (You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     *
     *  tags : 数组 动态规划
     *
     */
    //this is improper
    public int maxProfitHard(int[] prices) {
        int profit =0;
        for (int i= 1;i< prices.length-2;i++){
            int[] arr1 = new int[i+1];
            int[] arr2 = new int[prices.length-i-1];
            for (int j = 0; j<prices.length;j++){
                if(j<=i){
                    arr1[j]=prices[j];
                }else{
                    arr2[j-i-1] = prices[j];
                }
            }
            int i1 = maxProfitII(arr1);
            int i2 = maxProfitII(arr2);
            if (i1 + i2 > profit){
                profit = i1+i2;
            }
        }
        return  profit;
    }

    public int maxProfitHardRight(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }


    public static void main(String[] args) {
        int[] p = {1,7,9,5,10};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int i = bestTimeToBuyAndSellStock.maxProfitHard(p);
        System.out.println(i);
    }
}
