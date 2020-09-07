package com.isoldier.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author jinmeng on 2020/3/21.
 * @version 1.0
 */
public class FindCandidates {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        Stack<Integer> child =  new Stack<>();
        combine(candidates,target,res,child,0);
        return res;
    }


    public void combine(int[] candidates, int target, List<List<Integer>> res, Stack<Integer> child, int index){


        if(index >= candidates.length){
            return;
        }

        if(target <0){
            return;
        }else if(target == 0){
            List<Integer> childRes = new ArrayList<>();
            childRes.addAll(child);
            res.add(childRes);
        }else {

            for(int i = index;i <candidates.length; i++){
                if(target < candidates[i]){
                    break;
                }
                child.push(candidates[i]);
                combine(candidates,target-candidates[i],res,child,i);
                child.pop();
            }
        }

    }


    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        FindCandidates findCandidates =  new FindCandidates();
        List<List<Integer>> res = findCandidates.combinationSum(candidates,target);
        System.out.println(res);
    }

}
