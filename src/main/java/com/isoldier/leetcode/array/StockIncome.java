package com.isoldier.leetcode.array;

/**
 * Author: jinmeng
 * Date: 2017-04-26
 * Time: 16:53
 * 求股票的最大收益的最佳买入点卖出点
 */
public class StockIncome {

    public static void main(String[] args){
        int[] arr = {423,123,4,2,34,53,1,6,6,454,56,3,234};
        System.out.println(getMaxIncome(arr));
    }

    public static int getMaxIncome(int[] stockPrice){
        if(stockPrice.length<2) return -1;
        int maxIncome = Integer.MIN_VALUE;
        int buy = 0;
        int sell = 1;
        for(int i = 1;i < stockPrice.length-1;i++) {

            int curIncome = stockPrice[i] - stockPrice[buy];
            if(curIncome>maxIncome){
                maxIncome = curIncome;
                sell = i;
            }

            if (stockPrice[i] < stockPrice[buy]) {
                buy = i;
                sell = i;
            }
        }
        System.out.println("buy:"+buy+"---sell:"+sell);
        return maxIncome;
    }
}
