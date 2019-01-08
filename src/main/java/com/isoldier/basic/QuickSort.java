package com.isoldier.basic;


import java.util.Arrays;

/**
 * @author jinmeng on 2018/9/22.
 * @version 1.0
 */
public class QuickSort {

	public static void quickSort(int[] arr){
	    qsort(arr, 0, arr.length-1);
	}

	private static void qsort(int[] arr, int low, int high){
	    if (low < high){
	        int pivot=partition(arr, low, high);
	        qsort(arr, low, pivot-1);
	        qsort(arr, pivot+1, high);
	    }
	}
	private static int partition(int[] arr, int low, int high){
	    int pivot = arr[low];
	    while (low<high){
	        while (low<high && arr[high]>=pivot){
				--high;
			}
	        arr[low]=arr[high];
	        while (low<high && arr[low]<=pivot){
	        	++low;
			}
	        arr[high] = arr[low];
	    }
	    //扫描完成，枢轴到位
	    arr[low] = pivot;
	    //返回的是枢轴的位置
	    return low;
	}

	public static void main(String[] args){
		int[] arr = {13,2,23,5,2,4,6,2,43,6,2,4,2,423,5,1,23,4,23};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
}
	   

