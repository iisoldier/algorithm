package com.isoldier.dynamic;

/**
 * m*n网格从左上角到右下角一共有多少种走法  只能向右或者向下
 * @author jinmeng on 2020/5/29.
 * @version 1.0
 */
public class UniquePaths {

    public int uniquePaths(int m,int n){

        if(m < 0 || n < 0){
            return 0;
        }

        int[][] paths = new int[m][n];
        for(int i = 0;i<m;i++){
            paths[i][0]=1;
        }
        for(int i = 0;i<n;i++){
            paths[0][i]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                paths[i][j]=paths[i-1][j]+paths[i][j-1];
            }
        }

        return paths[m-1][n-1];

    }


    public static void main(String[] args) {

        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,2));
    }

}
