package com.isoldier.dfs;

import javax.sound.midi.Soundbank;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: jinmeng
 * Date: 2017-05-13
 * Time: 22:16
 */
public class TargetSum {

    static int result = 0;

    public static void main(String[] args){

        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }

    /**
     * nums中都是正数,给这些数加上正负号,满足所有数的和是S,求出所有可能行的数量
     * @param nums
     * @param S
     * @return
     */
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }
        int target = (S + sum)>>1;

        dfs(nums,0,target);

        return result;

    }

    public static void dfs(int[] nums, int start,int target){

        if(target == 0){
            result++;
        }
        if(target <= 0) return;

        for(int i = start; i < nums.length; i++){
            dfs(nums,i+1,target - nums[i]);
        }
    }
}
