package easy.linkList.q_206_reverse_linked_list;

import easy.linkList.common.ListNode;

import java.lang.reflect.Array;
import java.util.Arrays;


public class Solution {
    public static ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode prev = head, pNext = head.next;
        while (pNext != null){
            prev.next = pNext.next;
            pNext.next = head;
            head = pNext;
            pNext = prev.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.geNerateLinkedList(Arrays.asList(1,2));
        ListNode newHead = reverseList(head);
        ListNode.printLinkedList(newHead);

    }
}