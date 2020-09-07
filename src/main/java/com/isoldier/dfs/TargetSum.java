package com.isoldier.dfs;

/**
 * Author: jinmeng
 * Date: 2017-05-13
 * Time: 22:16
 */
public class TargetSum {

    static int result = 0;

    public static void main(String[] args){

        int[] nums = {1,1,1,1,1};

        targetSum(nums,0,3);
        System.out.println(result);
    }


    /**
     * nums中都是正数,给这些数加上正负号,满足所有数的和是S,求出所有可能行的数量
     * @param nums
     * @param start
     * @param target
     */
    public static void  targetSum(int[] nums,int start,int target){
        if(start == nums.length){
            if(target == 0){
                result++;
            }
            return;
        }
        targetSum(nums,start+1,target-nums[start]);
        targetSum(nums,start+1,target+nums[start]);
    }

}
