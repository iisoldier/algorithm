package com.isoldier.leetcode.array;

/**
 * 二分查找法
 * 
 * @author jinmeng
 *
 */
public class BinarySearch {
	public static void main(String[] args){

		int i =17;
		System.out.println(i >>2);
		int[] arr={1,2,3,4,5,6,7,8,9};
		System.out.println(binSearch(arr,3));
		int[] arr2={4};
//		int[] arr2={1,2,3,3,3,3,3,3,4,5,6,7,8,9};
		System.out.println(binSearchRepeat(arr2,4));
		System.out.println(binSearchRepeat2(arr2,4));
	}
	/**
	 * 二分查找,数组是排序好的整数,不重复,返回所在数组的index
	 * @param arr
	 * @param left
	 * @param right
	 * @param value
	 * @return
	 *
	 */

	public static int binSearch(int[] arr,int value){
		int left = 0;
		int right = arr.length-1;
		while(left <= right){
			int mid = left+(right-left)/2;
			if(arr[mid] == value){
				return mid;
			}else if(arr[mid] > value){
				right = mid-1;
			}else{
				left = mid +1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找,有重复元素,返回最左边的
	 * @param arr
	 * @param low
	 * @param high
	 * @param key
	 * @return
	 */
	public static int binSearchRepeat(int [] arr, int key){
		if(arr == null || arr.length<1) return -1;
		int left = 0;
		int right = arr.length-1;
		while(left+1<right){
			int mid = left + (right-left)/2;
			if(arr[mid]>=key){
				right= mid;
			}else{
				left = mid+1;
			}	
		}
		if(arr[left] == key){
			return left;
		}else if(arr[right] == key){
			return right;
		}else{
			return -1;
		}
	
	}
	public static int binSearchRepeat2(int [] arr, int key){
		if(arr == null || arr.length<1) return -1;
		int left = 0;
		int right = arr.length-1;
		while(left<right){
			int mid = left + (right-left)/2;
			if(arr[mid]>=key){
				right= mid;
			}else{
				left = mid+1;
			}	
		}
		if(arr[left] == key){
			return left;
		}else{
			return -1;
		}
	
	}
}
