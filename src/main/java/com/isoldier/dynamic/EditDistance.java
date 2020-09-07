package com.isoldier.dynamic;

/**
 * @author jinmeng on 2020/5/30.
 * @version 1.0
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] steps = new int[m+1][n+1];
        // 初始化第一列和第一行
        for(int i = 0;i <= m;i++){
            steps[i][0]=i;
        }
        for(int i = 0;i <= n;i++){
            steps[0][i]=i;
        }
        for(int i = 1;i <=m;i++){
            for(int j= 1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    steps[i][j] = steps[i-1][j-1];
                }else {
                    steps[i][j] = 1+ Math.min(steps[i-1][j-1], //replace
                            Math.min(steps[i][j-1], //insert
                                    steps[i-1][j])); //delete
                }
            }
        }
        return steps[m][n];

    }

    public static void main(String[] args) {
        String word1 = "adsf";
        String word2 = "adsd";
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance(word1,word2));
    }
}
