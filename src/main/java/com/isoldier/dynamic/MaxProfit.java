package com.isoldier.dynamic;

/**
 * 买卖股票的最佳时机
 * @author jinmeng on 2020/5/26.
 * @version 1.0
 */
public class MaxProfit {


    /**
     * 股票只能买卖一次
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int max = 0;
        if(prices.length == 0){
            return max;
        }
        int  min = prices[0];

        for(int i = 1; i<prices.length;i++){
            if(prices[i] >min){
                int currentProfit = prices[i]-min;
                max = max>currentProfit?max:currentProfit;
            }else {
                min = prices[i];
            }

        }
        return max;
    }


    /**
     * 股票允许多次买卖
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        if(prices.length == 0){
            return max;
        }
        int  buy = prices[0];

        for(int i = 1; i<prices.length;i++){
            if(prices[i] >buy){
                max += prices[i]-buy;
            }

            buy = prices[i];
        }
        return max;
    }



    /**
     * 最多完成两笔交易
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int max = 0;
        if(prices.length == 0){
            return max;
        }
        int  buy = prices[0];

        for(int i = 1; i<prices.length;i++){
            if(prices[i] >buy){
                max += prices[i]-buy;
            }

            buy = prices[i];
        }
        return max;
    }
}
