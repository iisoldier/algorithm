package com.isoldier.dynamic;

/**
 * 给定字符串s 找出最长的回文子串
 * @author jinmeng on 2020/5/27.
 * @version 1.0
 */
public class LongestPalindrome {

    /**
     * 该解法属于暴力解法，本机可以运行，LeetCode提交后超时
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length() <=1){
            return s;
        }
        int begin=0, end=0;
        int max=1;
        for(int i = 1;i<s.length();i++){
            for(int j = 0;j<i;j++){
                if(isValidPalindrome(s,j,i)){
                    if(i-j+1>max){
                        max = i-j;
                        begin = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(begin,end+1);
    }

    public boolean isValidPalindrome(String s,int start,int end){
        while (start< end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    /**
     * 使用动态规划解法
     * @param s
     * @return
     */
    public String dyLongestPalindrome(String s) {

        if(s.length() <=1){
            return s;
        }

        int len = s.length();
        int begin=0;
        int max=1;

        boolean[][] dy = new boolean[len][len];
        for(int i = 0; i<len;i++){
            dy[i][i] = true;
        }

        // 状态转移方程： dy[i][j] = dy[i+1][j-1] && s[i]==s[j]
        for(int j = 1;j<len;j++){
            for(int i = 0;i<j;i++){
                if(s.charAt(j)!=s.charAt(i)){
                    dy[i][j] =false;
                }else {
                    // j-1-(i+1) +1 <2 子串不构成序列
                    if(j-i<3){
                        dy[i][j]= true;
                    }else {
                        dy[i][j] = dy[i+1][j-1];
                    }
                }

                if(dy[i][j] && j-i+1>max){
                    max = j-i+1;
                    begin=i;
                }

            }
        }
        return s.substring(begin,begin+max);
    }


    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "asdffdas";
        String res = longestPalindrome.dyLongestPalindrome(s);

        System.out.println(res);
    }

}
