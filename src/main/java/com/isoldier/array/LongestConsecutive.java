package com.isoldier.array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Desc 给定一个未排序的数组，找出最长连续序列的长度，要求算法的时间复杂度是O(n)
 * 示例：
 * 输入:[100,4,200,1,3,2]
 * 输出：4
 * 解释：最长连续序列是[1,2,3,4]
 * @author jinmeng on 2020/3/22.
 * @version 1.0
 */
public class LongestConsecutive {


    public static int max = 1;

    public int longestConsecutive(int[] nums){

        if(nums.length == 0){
            return 0;
        }
        Set<Integer> record = new HashSet<>();
        for(int num : nums){
            record.add(num);
        }

        for(int i = 0;i<nums.length;i++){
            if(record.contains(nums[i]-1)){
                continue;
            }
//            find(nums,nums[i],record,0);

            //用循环代替递归
            int cur = 1;
            int key = nums[i]+1;
            while (record.contains(key)){
                key++;
                cur++;
            }
            if(cur>max){
                max= cur;
            }
        }
        return max;
    }

    /**采用递归的方式进行寻找
     *
     * @param nums
     * @param value
     * @param record
     * @param cur
     */

    public void find(int[] nums,int value,Set<Integer> record,int cur){

        if(record.contains(value)){
            cur++;
            if(cur>max){
                max = cur;
            }
            find(nums,value+1,record,cur);
        }
    }


    public static void main(String[] args) {
        int[] nums = {100,3,200,4,2,1};
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }

}
