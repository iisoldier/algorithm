package com.isoldier.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Desc: https://leetcode.com/problems/two-sum/
 * @author jinmeng on 2020/1/18.
 * @version 1.0
 */
public class TwoSum {

    public static void main(String[] args) {

    }

    public List<Integer> twoSum(int[] nums, int target) {

        List<Integer> result = new ArrayList<>();

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        if(nums.length >= 0){
            for(int i = 0; i < nums.length; i++){
                map.put(nums[i],i);
            }
            for(int i = 0; i < nums.length; i++){
                if(map.get(target-nums[i]) != null && map.get(target-nums[i]) != i){
                    result = Arrays.asList(i,map.get(target-nums[i]));
                }
            }
        }
        return result;
    }
}
