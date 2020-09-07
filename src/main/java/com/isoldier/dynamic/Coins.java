package com.isoldier.dynamic;

/**
 * 求硬币的组合,这个用动态规划更有效
 * 自底向上的原则
 * Author: jinmeng
 * Date: 2017-05-20
 * Time: 23:51
 */
public class Coins {

    public static void main(String[] args){

        int[] coins = {1,2,3,4,5};
        System.out.println(wayToChange(5,coins));
    }

    public static int change(int amount, int[] coins) {


        int[] result = new int[coins.length+1];
        //设置初始值
        result[0] = 1;

        // 硬币的种类
        for(int coin : coins){
            // 每一次相当于新增一种硬币 在原有的基础上更新结果
            for(int i = coin; i <= amount; i++){
                result[i] += result[i-coin];
            }
        }
        return result[amount];
    }




    public static int wayToChange(int amount, int[] coins) {


        int[] result = new int[amount+1];
        //设置初始值
        result[0] = 1;

        // 硬币的种类
        for(int coin :coins){
            for(int i=coin;i<amount;i++){

                result[i] = result[i-coin]+result[coin];
            }
        }

        return result[amount];
    }

}
