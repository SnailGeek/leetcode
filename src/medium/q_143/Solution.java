package medium.q_143;

import easy.linkList.common.ListNode;

import java.util.Arrays;

class Solution {
    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode leftHead = head, rightNode = slow.next;
        slow.next = null;
        ListNode rDummyHead = new ListNode(0, rightNode);
        while (rightNode != null && rightNode.next != null) {
            ListNode tmpNode = rDummyHead.next;
            rDummyHead.next = rightNode.next;
            rightNode.next = rDummyHead.next.next;
            rDummyHead.next.next = tmpNode;
        }

        ListNode lNode = leftHead, rNode = rDummyHead.next;
        while (rNode != null) {
            ListNode tmpNode = lNode.next;
            lNode.next = rNode;
            rNode = rNode.next;
            lNode.next.next = tmpNode;
            lNode = lNode.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode.printLinkedList(reorderList(ListNode.generateList(Arrays.asList(1, 2, 3, 4))));
    }
}