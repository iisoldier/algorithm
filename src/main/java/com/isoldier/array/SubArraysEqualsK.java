package com.isoldier.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jinmeng on 2019/5/30.
 * @version 1.0
 */
public class SubArraysEqualsK {



    public static int subArraySum(int[] nums, int k) {

        int len = nums.length;
        Map<Integer,Integer> sumMap = new HashMap();
        sumMap.put(0,1);
        int preSum = 0;
        int count = 0;
        for(int i = 0; i < len; i++){
            preSum += nums[i];
            count += sumMap.getOrDefault(preSum - k,0);
            sumMap.put(preSum,sumMap.getOrDefault(preSum,0)+1);
        }
        return  count;
    }


    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6};
        int k = 5;
        System.out.println(subArraySum(nums,k));
    }

}
