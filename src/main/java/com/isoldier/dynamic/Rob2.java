package com.isoldier.dynamic;

import java.util.Arrays;

/** 打家劫舍：不能偷取相邻的 升级版，收尾认为是相邻的
 * @author jinmeng on 2020/5/28.
 * @version 1.0
 */
public class Rob2 {


    public static int rob(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        //分成两部分 不包含尾部值的最大值  和不包含首位元素的最大值  两者相比较
        return Math.max(robBasic(Arrays.copyOfRange(nums,0,nums.length-1))
                ,robBasic(Arrays.copyOfRange(nums,1,nums.length)));

    }





    public static int robBasic(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        int[] max = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(i == 0){
                max[i] = nums[0];
            }
            if(i == 1){
                max[i] = Math.max(nums[0],nums[1]);
            }
            if(i > 1){
                max[i] = Math.max(max[i-1],nums[i]+max[i-2]);
            }
        }
        return max[nums.length -1];

    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,3};
        System.out.println(Rob2.rob(nums));
    }
}
