package medium.q_24;

import easy.linkList.common.ListNode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode pNode = head, ret = head.next;
        while (pNode != null && pNode.next != null) {
            pre.next = pNode.next;
            pNode.next = pre.next.next;
            pre.next.next = pNode;
            pre = pNode;
            pNode = pNode.next;
        }
        return ret;
    }

    public static ListNode swapPairs2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
//        ListNode.printLinkedList(swapPairs2(ListNode.geNerateLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6))));
        ListNode.printLinkedList(swapPairs2(ListNode.geNerateLinkedList(Arrays.asList(1, 2, 3, 4, 5))));
//        ListNode.printLinkedList(swapPairs2(ListNode.geNerateLinkedList(Arrays.asList(1, 2, 3))));
//        ListNode.printLinkedList(swapPairs2(ListNode.geNerateLinkedList(Arrays.asList(1))));
    }
}