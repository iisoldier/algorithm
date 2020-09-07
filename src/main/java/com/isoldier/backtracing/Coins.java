package com.isoldier.backtracing;

/**
 * 求硬币的组合,这个用动态规划更有效
 * Author: jinmeng
 * Date: 2017-05-20
 * Time: 23:51
 */
public class Coins {


    static int result = 0;


    public static void main(String[] args){

        int[] coins = {1,3,2};
        System.out.println(change(3,coins));
    }

    public static int change(int amount, int[] coins) {

        System.out.println(coins);
        backTracking(coins,0,amount);
        return result;
    }

    /**
     * 使用回溯法计算可能性的种类
     * @param coins 硬币面值数组
     * @param index
     * @param remain 剩余面额
     */
    public static void backTracking(int[] coins,int index,int remain){
        if(remain == 0){
            result++;
            System.out.println("-----------");
        }
        if(remain < 0) {
            return;
        }

        for(int i = index; i< coins.length;i++){
//          如果是i+1 组合中就不能出现重复的数字
//          backTracking(coins,i+1,remain-coins[i]);

            backTracking(coins,i,remain-coins[i]);
        }

    }


}
