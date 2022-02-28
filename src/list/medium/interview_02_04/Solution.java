package list.medium.interview_02_04;

import list.common.ListNode;

import java.util.Arrays;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pNode = head;
        while (pNode != null && pNode.next != null) {
            if (pNode.next.val < x) {
                dummyHead.next = pNode.next;
                pNode.next = pNode.next.next;
                dummyHead.next.next = head;
                head = dummyHead.next;
            } else {
                pNode = pNode.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        ListNode.printLinkedList(so.partition(ListNode.generateList(Arrays.asList(3, 5, 8, 5, 10, 2, 1)), 5));
    }
}