package com.isoldier.array;

/**
 * @author jinmeng on 2020/3/21.
 * @version 1.0
 */
public class SearchRange {

    public int[] searchRange(int[] nums,int target){

        int[]  res = {-1,-1};
        if(nums.length > 0){
            res[0] = findFirst(nums,target);
            if(res[0] == -1){
                return res;
            }else {
                res[1] = findLast(nums,target);
            }
        }
        return res;
    }

    public int findFirst(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left < right && right-left>1){
            int mid = (right+left)/2;
            if(nums[mid] >= target){
                right = mid;
            }else {
                left= mid;
            }
        }
        if(nums[left] == target){
            return left;
        }else if(nums[right] == target){
            return right;
        }else {
            return -1;
        }
    }

    public int findLast(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left < right && right-left>1){
            int mid = (right+left)/2;
            if(nums[mid] <= target){
                left = mid;
            }else {
                right= mid;
            }
        }
        if(nums[right] == target){
            return right;
        }else if(nums[left] == target){
            return left;
        }else {
            return -1;
        }
    }


    public static void main(String[] args) {
        SearchRange searchRange  = new SearchRange();

        int[] nums = {};
        int target = 0;
        int[] res = searchRange.searchRange(nums,target);
        System.out.println(res);
    }

}
