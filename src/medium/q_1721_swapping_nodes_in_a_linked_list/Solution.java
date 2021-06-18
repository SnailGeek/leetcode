package medium.q_1721_swapping_nodes_in_a_linked_list;

import easy.linkList.common.ListNode;

import java.util.Arrays;

class Solution {
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, slow = head, first = head, second = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        first = fast;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        second = slow;

        int tmpVal = first.val;
        first.val = second.val;
        second.val = tmpVal;
        return head;
    }


    public static ListNode swapNodes2(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode kNodePre = dummy;
        for (int i = 1; i < k; i++) {
            kNodePre = kNodePre.next;
        }
        ListNode slow = dummy, fast = kNodePre.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (kNodePre != slow) {
            ListNode kNode = kNodePre.next, lastKNode = slow.next;
            slow.next = kNode;
            kNodePre.next = lastKNode;
            ListNode tmp = lastKNode.next;
            lastKNode.next = kNode.next;
            kNode.next = tmp;
        }
        return dummy.next;
    }
    // 今天时间不多了，如果有时间可以挑战一下，不是通过值交换，而是真正的实现节点交换

    public static ListNode swapNodes3(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode kNodePre = dummyHead;
        for (int i = 1; i < k; i++) {
            kNodePre = kNodePre.next;
        }
        ListNode slow = dummyHead, fast = kNodePre.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (kNodePre != slow) {
            ListNode kNode = kNodePre.next, lastKNode = slow.next;
            kNodePre.next = lastKNode;
            slow.next = kNode;
            ListNode tmp = lastKNode.next;
            lastKNode.next = kNode.next;
            kNode.next = tmp;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode.printLinkedList(swapNodes3(ListNode.geNerateLinkedList(Arrays.asList(1, 2, 3, 4, 5)), 2));
    }
}