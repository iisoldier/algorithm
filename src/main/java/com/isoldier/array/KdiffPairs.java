package com.isoldier.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: jinmeng
 * Date: 2017-05-05
 * Time: 13:53
 */
public class KdiffPairs {
    public int findPairs(int[] nums, int k) {

        if(nums.length==0|| nums == null || k<0) return 0;
        int res = 0;
        Map<Integer,Integer> hashmap = new HashMap<>();
        for(int num : nums){
            hashmap.put(num,hashmap.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:hashmap.entrySet()){
            if(k == 0){
                if(entry.getValue()>=2) res++;
            }else{
                if(hashmap.containsKey(entry.getKey()+k)) res++;
            }

        }

        return  res;
    }
}
