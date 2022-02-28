package list.medium.q_147;

import list.common.ListNode;

import java.util.Arrays;

public class Solution {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode tmp = head;
            while (tmp != p || p == head) {
                if (p.next.val >= tmp.val && p.next.val < tmp.next.val) {
                    ListNode tt = tmp.next;
                    tmp.next = p.next;
                    p.next = p.next.next;
                    tmp.next.next = tt;
                    break;
                } else if (p.next.val < tmp.val) {
                    head = p.next;
                    p.next = p.next.next;
                    head.next = tmp;
                    break;
                } else if (p.next.val >= p.val) {
                    p = p.next;
                    break;
                }
                tmp = tmp.next;
            }
        }
        return head;
    }

    // 官方解法
    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
//        ListNode.printLinkedList(insertionSortList(ListNode.geNerateLinkedList(Arrays.asList(6, 8, 7, 2, 4))));
//        ListNode.printLinkedList(insertionSortList(ListNode.geNerateLinkedList(Arrays.asList(6, 5, 3, 1, 8, 7, 2, 4))));
        ListNode.printLinkedList(insertionSortList(ListNode.generateList(Arrays.asList(4, 19, 14, 5, -3, 1, 8, 5, 11, 15))));
//        ListNode.printLinkedList(insertionSortList(ListNode.geNerateLinkedList(Arrays.asList(1, 1))));
    }
}