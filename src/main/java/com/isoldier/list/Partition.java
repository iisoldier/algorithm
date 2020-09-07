package com.isoldier.list;

import java.util.Arrays;

/**
 * @author jinmeng on 2020/3/25.
 * @version 1.0
 */
public class Partition {

    public static ListNode partition(ListNode head, int x) {

        ListNode left =new ListNode(0),right = new ListNode(0);
        left.next=head;
        ListNode pre = left,cur=left.next,curRight = right;

        while (cur != null){
            if(cur.val>=x){
                curRight.next = cur;
                curRight = curRight.next;
                pre.next = cur.next;
            } else {
                pre =cur;
            }
            cur =cur.next;
        }
        pre.next = right.next;
        return left.next;
    }


    public static void main(String[] args) {
        ListNode demo  =  ListNode.init(Arrays.asList(1,4,3,2,5,3));

        ListNode res =  partition(demo,3);
        System.out.println(res);
    }
}
