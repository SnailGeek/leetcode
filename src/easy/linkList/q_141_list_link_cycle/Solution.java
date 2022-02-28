package easy.linkList.q_141_list_link_cycle;


import easy.linkList.common.ListNode;

import java.util.Arrays;

public class Solution {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode pSlow = head, pFast = head.next.next;
        while (pFast != null && pSlow != null && pFast != pSlow) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
        }
        return (pFast == null || pSlow == null) ? false : true;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generateList(Arrays.asList(1));
        System.out.println(hasCycle(head));
    }
} 