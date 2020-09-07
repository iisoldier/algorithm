package com.isoldier.leetcode.string;

public class FindDifference {

	public static void main(String[] args){
		char result = findDifference("abcde","abcfde");
		System.out.println(result);
		
	}
	public static char findDifference(String s,String t){
		char result = 0;
		for(int i = 0;i<s.length();i++){
			result ^= s.charAt(i);
		}
		for(int i = 0;i<t.length();i++){
			result ^= t.charAt(i);
		}
		return result;
	} 
}
