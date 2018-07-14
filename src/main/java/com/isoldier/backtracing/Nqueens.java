package com.isoldier.backtracing;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

/**
 * Author: jinmeng
 * Date: 2017-04-28
 * Time: 19:29
 * 八皇后问题 -- 经典的回溯法
 */
public class Nqueens {
    public static void main(String[] args){

        int[] result = new int[4];
        setQueens(4,0,result);
    }

    /**
     * 按列开始存放queen
     * @param n
     * @param lineIndex
     * @param result
     */
    public static void setQueens(int n,int lineIndex,int[] result){

        //所有行都放置完毕,输出结果
        if(lineIndex == n){
            print(result);
            System.out.println(Arrays.toString(result));
            return;
        }

        //循环堆每一行数据都尝试在每一列放置的可能行 回溯所有可能行
        for(int i = 0;i < n; i++){
            result[lineIndex] = i;
            if(isValid(result,lineIndex,i)){
                setQueens(n,lineIndex+1,result);
            }
        }
    }


    /**
     * 验证第line行 第col列是否可以放置queen
     * result[line] = col
     * @param board
     * @param line
     * @param col
     * @return
     */

    public static  boolean isValid(int[] board,int line, int col){

        for(int i = 0;i<line;i++){
            if(board[i] == col||line -i == Math.abs(board[i]-col))
                return false;
        }
        return true;
    }

    public static void print(int[] result){
        System.out.println("------------");
        for(int i = 0; i<result.length;i++){
            for(int j = 0; j < result.length;j++){
                if(result[i] == j){
                    System.out.print("Q");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
