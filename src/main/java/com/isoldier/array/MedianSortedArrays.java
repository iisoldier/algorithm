package com.isoldier.array;

import java.util.ArrayList;

/**
 *  详情参见 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author jinmeng on 2020/1/30.
 * @version 1.0
 */
public class MedianSortedArrays {

    public static void main(String[] args) {


        int[] nums1 = {};
        int[] nums2 = {4,5,6};
        System.out.println(findMedianSortedArrays(nums1,nums2));


    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return calMedian(mergeTwoSortedArrays(nums1,nums2));
    }


    public static double calMedian(int[] nums){
        int len = nums.length;
        if(len%2 == 0){
            return (nums[len/2]+nums[len/2-1])/2.0;
        }else {
            return Double.valueOf(nums[len/2]);
        }
    }


    public static int[] mergeTwoSortedArrays(int[] nums1, int[] nums2){
        ArrayList list = new ArrayList();
        if(nums1.length == 0 ){
            return nums2;
        }else if(nums2.length == 0){
            return nums1;
        }else{
            int m = nums1.length;
            int n = nums2.length;
            int[] res = new int[m+n];
            int i =0,j=0;
            for(int k = 0;k < m+n; k++){
                if(i >= m){
                    res[k] =nums2[j];
                    j++;
                    continue;
                }else if(j >= n){
                    res[k] =nums1[i];
                    i++;
                    continue;
                }
                if( nums1[i]<nums2[j]){
                    res[k] =nums1[i];
                    i++;
                }else{
                    res[k] = nums2[j];
                    j++;
                }
            }
            return res;
        }
    }
}
