package com.isoldier.array;

/**
 * 问题描述： Given n non-negative integers representing an elevation map
 *          where the width of each bar is 1,compute how much water it
 *          is able to trap after raining.
 *
 *          n is at least 2.
 * Author: jinmeng
 * Date: 2017-05-22
 * Time: 17:33
 */
public class TrapRain {
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxAreaDynamic(height));
    }


    /**
     * 基本解法，算出所有可能性然后取最大值
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int res = 0;

        for(int i = 0; i< height.length;i++){
            for(int j =i+1;j<height.length;j++){
                int h =  Math.min(height[i],height[j]);
                int max  = (j-i) * h;
                if(max > res){
                    res = max;
                }
            }
        }
        return res;
    }

    /**
     * 复杂度更小的解法
     * @param height
     * @return
     */
    public static int maxAreaDynamic(int[] height) {


        int maxLeft = 0, maxRight = height.length - 1;

        int max = Math.min(height[maxLeft], height[maxRight]) * height.length;

        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[maxLeft] < height[maxRight]) {

                if (height[left + 1] > height[left]) {
                    maxLeft = left+1;
                    int cur = Math.min(height[maxLeft], height[maxRight]) * (maxRight - maxLeft);
                    if (cur > max) {
                        max = cur;
                    }
                }
                left++;
            } else {
                if (height[right - 1] > height[right]) {
                    maxLeft = right-1;
                    int cur = Math.min(height[maxLeft], height[maxRight]) * (maxRight - maxLeft);
                    if (cur > max) {
                        max = cur;
                    }
                }
                right--;

            }
        }
        return max;
    }






}
