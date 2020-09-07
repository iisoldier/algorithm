package com.isoldier.dynamic;

/** 打家劫舍：不能偷取相邻的
 * @author jinmeng on 2020/5/28.
 * @version 1.0
 */
public class Rob {

    public static int rob(int[] nums) {

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

        int[] nums = {1,2,3,1};
        System.out.println(Rob.rob(nums));
    }
}
