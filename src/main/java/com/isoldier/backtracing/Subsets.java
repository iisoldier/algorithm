package com.isoldier.backtracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: jinmeng
 * Date: 2017-04-29
 * Time: 13:23
 * 求一个数组的所有子集
 */

public class Subsets {

    public static void main(String[] args){
        System.out.println("列出数组的所有子集");
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> templist = new Stack<>();
        int[] arr = {1,2,2};
        backTracing(result,templist,arr,0);

        for(int i = 0;i<result.size();i++){
            System.out.println(result.get(i));
        }



    }

    public static void backTracing(List<List<Integer>> result, Stack<Integer> tempList, int[] arrs,int start){

        result.add(new ArrayList<Integer>(tempList));

        for(int i = start;i< arrs.length;i++){
//            下面这一行可以过滤掉重复元素
            if(i!=start && arrs[i] == arrs[i-1]) continue;
            tempList.push(arrs[i]);
            backTracing(result,tempList,arrs,i+1);
            tempList.pop();
        }
    }
}
