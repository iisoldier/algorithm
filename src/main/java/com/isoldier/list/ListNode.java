package com.isoldier.list;

import java.util.List;

/**
 * @author jinmeng on 2020/3/22.
 * @version 1.0
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode(int x){
        this.val = x;
    }




    public static ListNode init(List<Integer> list){

        ListNode head= new ListNode(0);
        ListNode cur = head;

        for(int num : list){
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return head.next;
    }

}
