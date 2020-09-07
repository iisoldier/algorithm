package com.isoldier.greedy;

/**
 * @author jinmeng on 2020/5/31.
 * @version 1.0
 */
public class CompleteCircle {


    public int canCompleteCircuit(int[] gas, int[] cost) {

        int len = gas.length;

        int index = -1;
        int curRemain = 0;
        int totalRemain = 0;
        for(int i = 0;i<len;i++){
           int temp = gas[i]-cost[i];
           totalRemain+=temp;
           if(temp+curRemain < 0){
               index = -1;
               curRemain =0;
               continue;
           }else {
               if(curRemain==0){
                   index = i;
               }
               curRemain+=temp;
           }
        }
        return totalRemain<0?-1:index;
    }
}
