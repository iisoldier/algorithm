package com.isoldier.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @See https://leetcode.com/problems/3sum
 * @author jinmeng on 2020/3/20.
 * @version 1.0
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> res = new ArrayList<>();

        if(nums.length > 3){
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i<nums.length; i++){
                map.put(nums[i],i);
            }
            for(int i = 0 ; i<nums.length-2; i++){
                for(int j = i+1;j< nums.length-1;j++){
                    int temp = 0-nums[i]-nums[j];
                    if(map.get(temp) != null && map.get(temp) >j){

                        boolean exist = false;
                        for(List<Integer> list : res){
                            if(list.contains(nums[i]) && list.contains(nums[j])){
                                exist = true;
                                break;
                            }
                        }
                        if(!exist){
                            res.add(Arrays.asList(nums[i],nums[j],temp));
                        }
                    }
                }
            }
        }
        return  res;
    }
}
