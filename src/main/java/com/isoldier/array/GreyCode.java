package com.isoldier.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jinmeng
 * Date: 2017-05-22
 * Time: 11:22
 */
public class GreyCode {

    public static void main(String[] args){
        List<Integer> result = generateGreyCode(2);
        System.out.println(result.toString());

    }

    /**
     * 如何生成格雷码
     * @param n
     * @return
     */
    public static List<Integer> generateGreyCode(int n){
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for(int i = 0; i < n; i++){
            int size = result.size();
            for(int j = size-1; j>=0; j--){
                result.add(result.get(j) | 1<<i);
            }
        }
        return result;
    }
}
