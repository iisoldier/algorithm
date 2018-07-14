package com.isoldier.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jinmeng
 * Date: 2017-05-02
 * Time: 23:08
 * 查找出现两次的数字
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
   Could you do it without extra space and in O(n) runtime?
 */
public class FindDuplicate {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i< nums.length;i++){
            //关键点 1 ≤ a[i] ≤ n (n = size of array)
            int index = Math.abs(nums[i])-1;
            if(nums[index]<=0){
                result.add(index+1);
            }

            nums[index] = - nums[index];
        }
        return result;
    }

}

