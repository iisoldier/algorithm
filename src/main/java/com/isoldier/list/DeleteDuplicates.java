package com.isoldier.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jinmeng on 2020/3/22.
 * @version 1.0
 */
public class DeleteDuplicates {

    /**
     * 用set存储重复的值，然后再次遍历删除 ，leetcode提交后显示超时
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        Set<Integer> dup = new HashSet<>();

        ListNode pre = head;
        ListNode cur = head;

        while (cur.next != null){
            pre = cur;
            cur = cur.next;
            if(cur.val == pre.val){
                dup.add(cur.val);
            }
        }

        ListNode adjectiveHead = new ListNode(0);
        adjectiveHead.next = head;
        cur = adjectiveHead.next;
        while (cur!= null){

            if(dup.contains(cur.val)){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }

        }
        return adjectiveHead.next;
    }

    /**
     * 删除重复节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {

        ListNode adjectiveHead = new ListNode(0);
        adjectiveHead.next = head;

        ListNode ppre = adjectiveHead;

        ListNode cur = adjectiveHead;

        while (cur.next!= null && cur.next.next != null){


            if(cur.next.val == cur.next.next.val){

                ListNode temp = cur.next;
                while (temp!=null && temp.next != null && temp.next.val == temp.val){
                    temp = temp.next;
                }
                cur.next = temp.next;
            }else{
                cur =cur.next;
            }
        }
        return adjectiveHead.next;
    }





    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(6);

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode res = deleteDuplicates.deleteDuplicates2(head);
        System.out.println(res);


    }
}
