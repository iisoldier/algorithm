package com.isoldier.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jinmeng
 * Date: 2017-04-28
 * Time: 18:46
 * 括号匹配问题,求出n对小括号所有合法的可能性
 */
public class GenerateParentheses {

    public static void main(String[] args){

       List<String> result =  generateParentheses(3);
        System.out.println(result);
    }


    public static List<String> generateParentheses(int n){
        List<String> result = new ArrayList<>();
        backTracing(result,"",0,0,n);
        return  result;
    }

    public static void backTracing(List<String> list,String str,int open, int close,int target){
        if(str.length() == target*2){
            list.add(str);
            return;
        }
        if(open < target){
            backTracing(list,str+"(",open +1,close,target);
        }
        if(close < open ){
            backTracing(list,str+")",open ,close+1,target);
        }

    }
}
