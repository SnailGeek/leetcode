package easy.linkList.q_876_middle_of_the_Linked_list;


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
    public static ListNode middleNode(ListNode head) {
        int num = 0;
        ListNode p = head;
        while (p != null) {
            num++;
            p = p.next;
        }
        for (int i = 0; i < num / 2; i++) {
            head = head.next;
        }
        return head;
    }
    public static ListNode middleNode2(ListNode head){
        ListNode slow = head, faster = head;
        while (faster != null && slow != null){
            slow = slow.next;
            faster = faster.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode.printLinkedList(middleNode2(ListNode.geNerateLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }
}