package com.isoldier.leetcode.array;

public class FindNumbers {

	public static void main(String[] args){
	
		int[] arr = {1,2,3,4,5,6,7,8,9};
		findNumsWithSum(arr,10);
	
		
	}
	
	public static void findNumsWithSum(int[] arr,int sum){
		if (arr.length<2)
			return;
		int left = 0;
		int right = arr.length-1;
		
		while(left<right){
			int curSum = arr[left]+arr[right];
			if(curSum>sum) 
				right--;
			if(curSum<sum)
				left++;
			if(curSum==sum){
				System.out.println(left+""+right);
				break;
			}
		}
	
	}
}
