package com.isoldier.dynamic;

import java.util.Arrays;

/**
 * 求硬币的组合,这个用动态规划更有效
 * Author: jinmeng
 * Date: 2017-05-20
 * Time: 23:51
 */
public class Coins {

    public static void main(String[] args){

        int[] coins = {1,2,3,4,5};
        System.out.println(change(5,coins));
    }

    public static int change(int amount, int[] coins) {


        int[] result = new int[coins.length+1];
        result[0] = 1;
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                result[i] += result[i-coin];
            }
        }
        return result[amount];
    }
}
