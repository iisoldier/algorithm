package com.isoldier.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环,
 * @author jinmeng on 2020/3/22.
 * @version 1.0
 */
public class HasCircle {

    public boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();

        while (head != null){
            if(set.contains(head)){
                return true;
            }else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }


}
