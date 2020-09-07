package com.isoldier.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个正整数n，给出n对()可能给出的合法表达式
 * @author jinmeng on 2020/3/21.
 * @version 1.0
 */
public class Brackets {

    public List<List<String>> allBrackets(int num){

        List<List<String>> res = new ArrayList<>();
        LinkedList<String> brackets = new LinkedList<>();

        allBrackets(num,num,res,brackets);
        return res;
    }


    public void allBrackets(int left,int right,List<List<String>> res,LinkedList<String> brackets){

        if(left ==0 && right == 0){
            res.add(new ArrayList<>(brackets));
        }else {

            if(left>0){
                brackets.addLast("(");
                allBrackets(left-1,right,res,brackets);
                brackets.removeLast();
            }
            if(right>0 && right >left){
                brackets.addLast(")");
                allBrackets(left,right-1,res,brackets);
                brackets.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        System.out.println(brackets.allBrackets(2));
    }
}
