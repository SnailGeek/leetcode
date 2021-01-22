package medium.q_328;

import easy.linkList.common.ListNode;

import java.util.Arrays;

public class Solution {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head, pLast = head.next;
        while (pLast != null && pLast.next != null) {
            ListNode pt = pre.next;
            pre.next = pLast.next;
            pLast.next = pre.next.next;
            pre.next.next = pt;
            pre = pre.next;
            pLast = pLast.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.geNerateLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode head1 = ListNode.geNerateLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListNode head2 = ListNode.geNerateLinkedList(Arrays.asList(1));
        ListNode.printLinkedList(oddEvenList(head));
        ListNode.printLinkedList(oddEvenList(head1));
        ListNode.printLinkedList(oddEvenList(head2));
    }
}