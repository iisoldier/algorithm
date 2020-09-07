package com.isoldier.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jinmeng on 2020/3/23.
 * @version 1.0
 */
public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {

        Set<Integer> set = new HashSet<>();

        ListNode pre= head,cur = head;
        while (cur!= null){
            if(set.contains(cur.val)){
                pre.next = cur.next;
            }else {
                set.add(cur.val);
                pre = cur;
            }
            cur =cur.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(6);


        RemoveDuplicateNodes removeDuplicateNodes  =  new RemoveDuplicateNodes();
        removeDuplicateNodes.removeDuplicateNodes(head);
        System.out.println(head);


    }
}
