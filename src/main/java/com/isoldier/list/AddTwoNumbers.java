package com.isoldier.list;

/**
 * 链表相加
 * @author jinmeng on 2020/3/22.
 * @version 1.0
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode head = res;
        ListNode cur = res;
        ListNode pre = res;
        int plus = 0;
        while (true){
            if(l1 == null && l2 == null){
                if(plus > 0){
                    pre.next = new ListNode(plus);
                }
                break;
            }if(l1 == null){
                pre.next = add(l2,plus);
                break;
            }else if(l2 == null){
                pre.next = add(l1,plus);
                break;
            }else {
                int sum = l1.val+ l2.val+plus;
                int val  = sum % 10;
                plus = sum/10;
                if(cur == null){
                    cur = new ListNode(val);
                    pre.next =cur;
                }else {
                    cur.val =val;
                }
                pre = cur;
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return head;
    }


    public ListNode add(ListNode node,int plus){
        ListNode head  = node;
        ListNode cur  = node;
        ListNode pre = node;

        while (plus>0){
            if(cur == null){
                cur = new ListNode(0);
                pre.next =cur;
            }
            int sum = cur.val+plus;
            cur.val = sum % 10;
            plus = sum / 10;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }




    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode adjectiveHead = new ListNode(0);
        ListNode cur = adjectiveHead;

        int plus = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null? 0 : l1.val;
            int v2 = l2 == null? 0 : l2.val;
            int sum = v1 + v2 + plus;
            int v = sum % 10;
            plus = sum / 10;

            cur.next = new ListNode(v);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(plus > 0){
            cur.next = new ListNode(plus);
        }
        return adjectiveHead.next;
    }

    public static void main(String[] args) {

        ListNode l1= new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2= new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode res = addTwoNumbers.addTwoNumbers(l1,l2);

        ListNode res2 = addTwoNumbers.addTwoNumbers2(l1,l2);
        System.out.println(res);



    }
}
