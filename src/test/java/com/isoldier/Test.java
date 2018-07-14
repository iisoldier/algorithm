package com.isoldier;

import java.util.Arrays;
import java.util.Collections;

public class Test {

	public static void main(String[] args){
		
		int[] coins = {2,7,4,6};
		Arrays.sort(coins);
		System.out.println(Arrays.toString(coins));

		Integer[] ints = new Integer[] { 3,5,2,9 };
		Arrays.sort(ints,Collections.reverseOrder());
		System.out.println(Arrays.toString(ints));
	}
}
