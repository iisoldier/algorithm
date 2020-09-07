package com.isoldier.search;

/**
 * @author jinmeng on 2020/3/29.
 * @version 1.0
 */
public class SearchInsert {


    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        while (start <= end){

            int mid =  (start+end)/2;
            if(nums[mid] ==target){
                return mid;
            }else if(nums[mid]>target){
                end = mid -1;
            }else {
                start = mid+1;
            }
        }

        return start;

    }

    public static void main(String[] args) {

        int[]  arr = {2,3,4,5,6,7,8,9,10};

        SearchInsert searchInsert = new SearchInsert();
        int res = searchInsert.searchInsert(arr,11);
        System.out.println(res);
    }

}
