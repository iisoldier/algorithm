package com.isoldier.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jinmeng on 2020/3/23.
 * @version 1.0
 */
public class RemoveZeroSumSublists {

    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null){
            list.add(cur.val);
            cur =cur.next;
        }
        list = removeSumDup(list);
        ListNode newHead = new ListNode(0);
        cur = newHead;
        for(int val : list){
            cur.next= new ListNode(val);
            cur = cur.next;
        }
        return  newHead.next;
    }


    public static List<Integer> removeSumDup(List<Integer> list){


        int left = -1,right = -1;
        boolean del = true;
        int sum = 0;
        while (del){
            for(int i = 0;i <list.size();i++){
                for(int j = i;j <list.size();j++){
                    sum+=list.get(j);
                    if(sum == 0){
                        left = i;
                        right =j;
                        break;
                    }
                }
                sum = 0;
                if(left>=0){
                    break;
                }
            }
            if(left>=0){
                List<Integer> newList = new ArrayList<>();
                for(int i = 0; i< list.size();i++){
                    if(i >= left && i <= right){
                        continue;
                    }
                    newList.add(list.get(i));
                }
                list = newList;
                left = -1;
                right= -1;
                del = true;
            }else {
                del = false;
            }

        }
        return list;
    }


    /**
     * 优秀解法；
     * 思想：如果一段区间和为0 ，那么从头开始计算出的总和，两个节点是相等的
     * @return
     */

    public ListNode removeZeroSumSublistsBetter(ListNode head) {

        ListNode adjectiveHead = new ListNode(0);
        adjectiveHead.next =head;
        Map<Integer,ListNode> map = new HashMap<>();

        ListNode cur = head;
        int sum = 0;
        while (cur != null){
            sum += cur.val;
            map.put(sum,cur);
            cur = cur.next;
        }

        cur = adjectiveHead;
        sum = 0;
        while (cur != null){
            sum += cur.val;
            if(map.get(sum) != null){
                cur.next = map.get(sum).next;
            }
            cur =cur.next;
        }
        return  adjectiveHead.next;

    }


    public static void main(String[] args) {

        List<Integer> demo = Arrays.asList(1,2,3,4,-4,-3,0,0);
        List<Integer> res = removeSumDup(demo);
        System.out.println(res);
    }
}
