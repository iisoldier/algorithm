package com.isoldier.dynamic;

/**
 * 问题描述： Given n non-negative integers representing an elevation map
 *          where the width of each bar is 1,compute how much water it
 *          is able to trap after raining.
 *
 * Author: jinmeng
 * Date: 2017-05-22
 * Time: 17:33
 */
public class TrapRain {
    public static void main(String[] args){
        int[] height = {6,2,0,2,4,0,6};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {

        //游标索引
        int left = 0;
        int right = height.length-1;

        //最大值标志
        int maxLeft = 0;
        int maxRight = 0;

        // 结果
        int result = 0;

        while(left < right){

            //如果左边的最大值比较小 就以左边为准开始计算
            if(height[left] <= height[right]){

                if(height[left]>maxLeft){
                    //更新左边最大值
                    maxLeft = height[left];
                }else{
                    //能存水量是 左边最大值-当前值
                    result += (maxLeft - height[left]);
                }
                // 如果左边低就右移
                left++;

            }else{

                if(height[right]>maxRight){
                    //更新左边最大值
                    maxRight = height[right];
                }else{
                    //能存水量是 左边最大值-当前值
                    result += (maxRight - height[right]);
                }
                //如果右边低就左移
                right--;
            }
        }
        return result;

    }
}
