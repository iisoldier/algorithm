package com.isoldier.search;

/**
 * @author jinmeng on 2020/3/31.
 * @version 1.0
 */
public class FindPeak {


    public int findPeakElement(int[] nums) {
        return searchPeak(nums, 0, nums.length - 1);
    }

    /**
     * 找出任何以满足条件的峰值
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int searchPeak(int[] nums, int left, int right) {

        if(left>= right){
            return left;
        }
        int mid = (left+right)/2;

        if(nums[mid]>nums[mid+1]){
            right = mid;
        }else {
            left = mid+1;
        }
        return searchPeak(nums,left,right);

    }


    public static void main(String[] args) {
        int[]  nums = {1,2,3,1};
        FindPeak findPeak = new FindPeak();
        findPeak.findPeakElement(nums);
    }





}
