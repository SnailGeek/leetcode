package medium.q_86;

import easy.linkList.common.ListNode;

import java.util.Arrays;

public class Solution {
    public static ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode smallNode = smallHead, largeNode = largeHead;

        while (head != null) {
            if (head.val < x) {
                smallNode.next = head;
                smallNode = smallNode.next;
            } else {
                largeNode.next = head;
                largeNode = largeNode.next;
            }
            head = head.next;
        }
        largeNode.next = null;
        smallNode.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode.printLinkedList(partition(ListNode.generateList(Arrays.asList(1, 4, 3, 2, 5, 2)), 3));
    }
}