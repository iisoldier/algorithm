package com.isoldier.array;

/**
 * @author jinmeng on 2020/3/31.
 * @version 1.0
 */
public class MaxSubArray {


    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i = 0;i<nums.length-1;i++){
            curSum+=nums[i];
            if(curSum >max){
                max =curSum;
            }
            if(curSum < 0){
                curSum =0;
            }
        }
        return max;
    }

}
