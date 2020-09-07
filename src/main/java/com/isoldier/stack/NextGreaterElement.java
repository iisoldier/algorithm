package com.isoldier.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Author: jinmeng
 * Date: 2017-05-12
 * Time: 21:43
 */
public class NextGreaterElement {


    public static void main(String[] args){

        int[] findNums = {2,4};
        int[] nums = {1,3,2,4};
        System.out.println(Arrays.toString(nextGreaterElement(findNums,nums)));
    }
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {

        Deque<Integer> stack = new LinkedList<Integer>();

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int num : nums){

            while (!stack.isEmpty() && stack.peek()<num){
                map.put(stack.poll(),num);
            }
            stack.push(num);
        }
        int[] result = new int[findNums.length];
        for(int i = 0;i<findNums.length;i++){
            if(map.get(findNums[i])!=null){
                result[i] = map.get(findNums[i]);
            }else{
                result[i]=-1;
            }
        }
        return result;
    }

}
