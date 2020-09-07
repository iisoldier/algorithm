package com.isoldier.dynamic;

/**
 * 找零  使用最少个数的零钱
 * @author jinmeng on 2020/5/29.
 * @version 1.0
 */
public class BestChange {

    public static void main(String[] args) {

        int[] coins = {2};
        System.out.println(change(3,coins));

    }

    /**
     * @param amount 目标值
     * @param coins 钱币种类
     * @return
     */
    public static int change(int amount, int[] coins) {

        int[] kinds = new int[amount+1];
        kinds[0] = 0;
        for(int i = 1;i<=amount;i++){

            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                if(i-coin>=0 && kinds[i-coin]>=0){
                    int temp =1+kinds[i-coin];
                    if(temp <min){
                        min =temp;
                    }
                }
            }
            if(min == Integer.MAX_VALUE){
                kinds[i]=-1;
            }else {
                kinds[i]=min;
            }
        }
        return kinds[amount]>0?kinds[amount]:-1;
    }
}
