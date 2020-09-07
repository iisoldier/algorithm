package com.isoldier.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。、
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 进阶:
 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

 示例:
 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出: 7 -> 8 -> 0 -> 7

 * @author jinmeng on 2020/3/22.
 * @version 1.0
 */
public class AddTwoNumbers2 {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode adjectiveNode = new ListNode(0);

        ListNode l1Head = l1, l2Head = l2;
        int len1=0,len2=0;
        while (l1 != null || l2 !=null){
            if(l1 != null){
                len1++;
                l1= l1.next;
            }
            if(l2 != null){
                len2++;
                l2 = l2.next;
            }
        }
        ListNode big = len1 >len2? l1Head:l2Head;
        ListNode small = len1 >len2? l2Head:l1Head;
        adjectiveNode.next = big;

        ListNode cur = small;

        int dis = Math.abs(len1-len2);
        int maxLen = len1 >len2? len1+1:len2+1;
        List<Integer> carry = new ArrayList<>();
        for(int i =0; i< maxLen;i++){
            if(i<=dis){
                carry.add(0);
            }else {
                carry.add(cur.val);
                cur =cur.next;
            }
        }
        boolean keep =true;
        while (keep){
            cur = adjectiveNode.next;
            keep = false;
            for(int i = 1;i<maxLen;i++){
                int sum = cur.val+carry.get(i);
                cur.val = sum%10;
                carry.set(i,0);
                carry.set(i-1,carry.get(i-1)+sum/10);
                if(sum >=10){
                    keep= true;
                }
                cur = cur.next;
            }
        }
        if(carry.get(0)>0){
            adjectiveNode.val = 1;
            return adjectiveNode;
        }else {
            return adjectiveNode.next;
        }

    }

    /**
     * 更好的解法 使用辅助栈
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbersBetter(ListNode l1, ListNode l2) {


        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur1 =l1, cur2 =l2;
        while(cur1 != null || cur2 != null){
            if(cur1!= null){
                stack1.push(cur1.val);
                cur1 = cur1.next;
            }
            if(cur2!=null){
                stack2.push(cur2.val);
                cur2= cur2.next;
            }
        }

        ListNode res = new ListNode(0);
        int plus = 0;
        while (!stack1.empty() || !stack2.empty()){

            int v1 = 0, v2 = 0;
            if(!stack1.empty()){
                v1=stack1.pop();
            }
            if(!stack2.empty()){
                v2=stack2.pop();
            }
            int sum = v1 +v2+ plus;
            if(sum >0){
                ListNode front = new ListNode(sum%10);
                front.next = res.next;
                res.next = front;
                plus = sum/10;
            }
        }
        if(plus>0){
            res.val = plus;
            return res;
        }
        return  res.next;
    }




    public static void main(String[] args) {

        ListNode l1= new ListNode(4);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2= new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers2 addTwoNumbers = new AddTwoNumbers2();
        ListNode res = addTwoNumbers.addTwoNumbersBetter(l1,l2);
        System.out.println(res);



    }
}
