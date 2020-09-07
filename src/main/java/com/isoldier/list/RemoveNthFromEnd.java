package com.isoldier.list;

/**
 * @author jinmeng on 2020/3/22.
 * @version 1.0
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cur = head;
        int len = 0;
        while (cur != null){
            cur = cur.next;
            len++;
        }
        // 从前面 删除第K个节点
        int k = len - n +1;

        ListNode adjectiveHead = new ListNode(0);
        adjectiveHead.next = head;

        ListNode front = adjectiveHead;
        ListNode  back = adjectiveHead;

        for(int i = 1;i <= k;i++){
            front = back;
            back = back.next;
        }
        if(back == null){
            front.next = null;
        }else {
            front.next = back.next;
        }
        return adjectiveHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode res = removeNthFromEnd(head,1);
        System.out.println(res);
    }

}
