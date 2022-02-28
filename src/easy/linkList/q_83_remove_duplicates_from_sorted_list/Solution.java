package easy.linkList.q_83_remove_duplicates_from_sorted_list;


import easy.linkList.common.ListNode;

import java.util.Arrays;

public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head, pNext = head.next;
        while (pNext != null) {
            if (pre.val == pNext.val) {
                pre.next = pNext.next;
                pNext = null;
                pNext = pre.next;
            } else {
                pre = pre.next;
                pNext = pNext.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.generateList(Arrays.asList(1, 1));
        ListNode head2 = ListNode.generateList(Arrays.asList(1, 1, 2, 3, 3));
        ListNode head3 = ListNode.generateList(Arrays.asList(1));
        ListNode head4 = ListNode.generateList(Arrays.asList(1, 3));
        ListNode head5 = ListNode.generateList(Arrays.asList(1, 3, 3));
        System.out.println("head1: ");
        ListNode.printLinkedList(deleteDuplicates(head1));
        System.out.println("head2: ");
        ListNode.printLinkedList(deleteDuplicates(head2));
        System.out.println("head3: ");
        ListNode.printLinkedList(deleteDuplicates(head3));
        System.out.println("head4: ");
        ListNode.printLinkedList(deleteDuplicates(head4));
        System.out.println("head5: ");
        ListNode.printLinkedList(deleteDuplicates(head5));
    }
}