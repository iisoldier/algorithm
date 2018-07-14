package com.isoldier.leetcode.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 问题描述:
 * 	Given a non-empty array of integers, return the k most frequent elements.

	For example,
	Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * @author jinmeng
 *
 */
public class TopK {
	
	public static void main(String[] args){
		
		int[] nums = {1,1,1,1,2,2,2,3,3,4,5,3};
		System.out.println(getTopK(nums,3));
		
	}
	
	/**
	 * 使用最小堆实现
	 * @param nums
	 * @param k
	 * @return
	 */
	public static List<Integer> getTopK(int[] nums, int k){
		
		Map<Integer,Integer> frequentMap = new HashMap<Integer,Integer>();
		for(int num:nums){
			frequentMap.put(num, frequentMap.get(num)==null?1:frequentMap.get(num)+1);
		}
		
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Queue<Map.Entry<Integer,Integer>> prioQueue = new PriorityQueue(k,new Comparator<Map.Entry<Integer,Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> entry1, Entry<Integer, Integer> entry2) {					
				return entry1.getValue()-entry2.getValue();
			}			
		});
		
		for(Map.Entry<Integer, Integer> iter:frequentMap.entrySet()){
			if(prioQueue.size()<k){
				prioQueue.add(iter);
			}else{
				Map.Entry<Integer, Integer> head = prioQueue.peek();
				if(head.getValue()-iter.getValue()<0){
					prioQueue.poll();
					prioQueue.add(iter);
				}
			}
		}
		
		System.out.println(prioQueue);
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0;i<k;i++){
			result.add(prioQueue.poll().getKey());
		}
		return result;
	}
	

}
