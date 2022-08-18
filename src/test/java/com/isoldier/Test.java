package com.isoldier;

import java.util.Arrays;
import java.util.Collections;

public class Test {

	public static void main(String[] args){

		System.out.println(String.valueOf(0.072));
		Double val = Double.parseDouble(String.valueOf(0.072)) - Double.parseDouble(String.valueOf(0.028)) / Double.parseDouble(String.valueOf(0.028));
		System.out.println(val);
	}
}
