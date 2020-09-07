package com.isoldier.sort;


import java.util.Arrays;

/**
 * 快速排序
 * @author jinmeng on 2018/9/22.
 * @version 1.0
 */
public class QuickSort {

	public static void quickSort(int[] arr){
		qSort(arr, 0, arr.length-1);
	}

	public static void qSort(int[] arr,int start,int end){
		if(start > end){
			return;
		}
		int index = partition(arr,start,end);
		qSort(arr,start,index-1);
		qSort(arr,index+1,end);
	}



	public static int partition(int[] arr,int start,int end){

		int pivot = arr[start];
		while (start < end){

			while (arr[end] > pivot && start<end){
				end--;
			}
			arr[start] = arr[end];
			while (arr[start] <= pivot && start<end){
				start++;
			}

			arr[end] = arr[start];
			arr[start] =pivot;
		}
		return start;
	}





	public static void main(String[] args){
		int[] arr = {4,2,3,7,1,8,5,9,4,5,3,6};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
}
	   

