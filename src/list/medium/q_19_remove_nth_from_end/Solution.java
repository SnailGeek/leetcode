package list.medium.q_19_remove_nth_from_end;

import list.common.ListNode;

import java.util.Arrays;

/**
 * 删除链表的倒数第n个节点
 *
 * @program: Solution
 * @description:
 * @author: wangf-q
 * @date: 2022-02-28 21:16
 **/
public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pSlow = dummyHead, pFast = dummyHead;
        while (pFast != null) {
            if (n < 0) {
                pSlow = pSlow.next;
            }
            pFast = pFast.next;
            n--;
        }
        pSlow.next = pSlow.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        final ListNode head = ListNode.generateList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode.printLinkedList(Solution.removeNthFromEnd(head, 3));
        ListNode.printLinkedList(Solution.removeNthFromEnd(head, 4));
    }
}
