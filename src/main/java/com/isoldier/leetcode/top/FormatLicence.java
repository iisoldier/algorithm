package com.isoldier.leetcode.top;

public class FormatLicence {

	 public static String licenseKeyFormatting(String s, int k) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = s.length() - 1; i >= 0; i--)
	            if (s.charAt(i) != '-')
	                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
	        return sb.reverse().toString().toUpperCase();
	    } 
	 
	 public static void main(String[] args){
		 
		 System.out.println(licenseKeyFormatting("2-4A0r7-4k",4));
	 }
}
