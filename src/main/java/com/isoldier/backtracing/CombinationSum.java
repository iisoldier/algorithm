package com.isoldier.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Author: jinmeng
 * Date: 2017-04-28
 * Time: 22:19
 */
public class CombinationSum {

    public static void main(String[] args){
        int[] candidates = {2,3,4,7};
        List<List<Integer>> result = combineSum(candidates,7);

        for(int i = 0;i<result.size();i++){
            System.out.println(result.get(i));
        }
        System.out.println(result.toArray().toString());
    }

    public static List<List<Integer>> combineSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> tempList = new Stack<>();

        Arrays.sort(candidates);
        backTracing(result,tempList,candidates,target,0);
        return result;
    }

    /**
     *
     * @param result 返回结果
     * @param tempList 返回结果的子集
     * @param sortedNums 排序好的数组
     * @param remain 剩下的和
     * @param start 有序数组的位置
     */
    public static void backTracing(List<List<Integer>> result,Stack<Integer> tempList,int[] sortedNums,int remain,int start){

        if(remain<0) return;
        if(remain == 0) result.add(new ArrayList<Integer>(tempList));

        for(int i = start;i < sortedNums.length;i++){
            tempList.push(sortedNums[i]);
            backTracing(result,tempList,sortedNums,remain-sortedNums[i],i);
            tempList.pop();
        }

    }
}
