package com.isoldier.list;

/**
 * 反转链表
 * @author jinmeng on 2020/3/22.
 * @version 1.0
 */
public class ReverseList {


    /**
     * 反转链表 采用循环的方式实现
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode front = null;
        ListNode cur = head;
        ListNode back = head;
        while (cur!= null && cur.next != null){
            back = cur.next;
            cur.next = front;
            front = cur;
            cur = back;
        }
        cur.next = front;
        return cur;
    }


    /**
     * 使用递归的方式实现链表反转
     * @param head
     * @return
     */
    public static ListNode reverseListRecursion(ListNode head) {

        if(head == null || head.next ==null){
            return head;
        }
        ListNode lastNode = head;
        ListNode node = reverseListRecursion(lastNode.next);

        // 需要将node的最后一个节点 指向 lastNode
//        ListNode cur = node;
//        while (cur!=null && cur.next != null){
//            cur= cur.next;
//        }
//        cur.next = lastNode;

        // 简单做法，因为lastNode 本身是指向node的最后一个节点的
        lastNode.next.next = lastNode;
        lastNode.next = null;

        return node;
    }








    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode res =  reverseListRecursion(head);

        System.out.println(res);


    }


}
