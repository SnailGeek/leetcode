package easy.linkList.q_203_remove_linked_list_elements;


import easy.linkList.common.ListNode;

import java.util.Arrays;

public class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode pre = head, pNext = head.next;
        while (pNext != null) {
            if (pNext.val == val) {
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


    public static ListNode removeElements2(ListNode head, int val) {
        //可以利用递归实现一版, 时间复杂度和空间复杂度都差一点🙅
        if (head == null) {
            return null;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.generateList(Arrays.asList(1, 2, 3, 2));
        ListNode head2 = ListNode.generateList(Arrays.asList(2, 2, 2));
        ListNode head3 = ListNode.generateList(Arrays.asList(2, 2, 1));
        System.out.println("head1:");
        ListNode.printLinkedList(removeElements2(head1, 2));
        System.out.println("head2:");
        ListNode.printLinkedList(removeElements2(head2, 2));
        System.out.println("head3:");
        ListNode.printLinkedList(removeElements2(head3, 2));
    }

}