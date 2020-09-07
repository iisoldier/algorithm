package com.isoldier.search;

/**
 *
 * @author jinmeng on 2020/3/29.
 * @version 1.0
 */
public class RotatedSortedArray {



    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        while (left <= right && left >=0){

            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >target){
                if(nums[right] < nums[mid] && nums[right] >= target){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }else {
                if(nums[left] > nums[mid] && nums[left] <= target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }

        return -1;

    }


}
