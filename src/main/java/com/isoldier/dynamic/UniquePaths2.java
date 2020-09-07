package com.isoldier.dynamic;

/**
 * m*n网格从左上角到右下角一共有多少种走法 只能向右或者向下  有障碍物
 * @author jinmeng on 2020/5/29.
 * @version 1.0
 */
public class UniquePaths2 {

    public int uniquePaths(int[][] obstacleGrid){

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m <= 0 || n <= 0 ||obstacleGrid[0][0]==1){
            return 0;
        }

        int[][] paths = new int[m][n];
        paths[0][0]=obstacleGrid[0][0];
        for(int i = 1;i<m;i++){
            if(obstacleGrid[i][0] == 0){
                paths[i][0]=paths[i-1][0];
            }else {
                paths[i][0]=0;
            }
        }
        for(int i = 1;i<n;i++){
            if(obstacleGrid[0][i] == 0){
                paths[0][i]=paths[0][i-1];
            }else {
                paths[0][i]=0;
            }
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    paths[i][j] =0;
                }else {
                    paths[i][j]=paths[i-1][j]+paths[i][j-1];
                }
            }
        }

        return paths[m-1][n-1];

    }



}
