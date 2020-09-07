package com.isoldier.tree;


import com.isoldier.common.TreeNode;

import java.util.Arrays;

/**
 * 将有序链表转化成二叉树
 * @author jinmeng on 2020/3/28.
 * @version 1.0
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode mid = getMid(head);
        TreeNode  root = new TreeNode(mid.val);

        //如果只剩下一个元素 那么mid == head
        if(head.val ==mid.val){
            root.left = null;
        }else {
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(mid.next);

        return root;
    }



    ListNode getMid(ListNode head){

        if(head == null){
            return null;
        }
        ListNode prePtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr !=null && fastPtr.next!=null){
            prePtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // 将链表分隔成左右两个链表
        if(prePtr !=null){
            prePtr.next = null;
        }
        return slowPtr;
    }


    public static void main(String[] args) {

        ListNode listNode =  ListNode.init(Arrays.asList(1,2,3,4,5,6,7,8));
        SortedListToBST sortedListToBST = new SortedListToBST();
        TreeNode root = sortedListToBST.sortedListToBST(listNode);
        System.out.println(root);
    }



}
