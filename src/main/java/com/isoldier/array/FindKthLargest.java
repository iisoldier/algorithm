package com.isoldier.array;

/**
 * @author jinmeng on 2020/3/31.
 * @version 1.0
 */
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {

        for(int i = 0; i< k;i++){
            for(int j = nums.length-1;j>0;j--){
                if(nums[j]>=nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        return nums[k-1];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int res = findKthLargest(arr,4);
        System.out.println(res);
    }
}
