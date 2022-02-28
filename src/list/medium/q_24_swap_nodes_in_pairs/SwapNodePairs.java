package list.medium.q_24_swap_nodes_in_pairs;

import list.common.ListNode;

import java.util.Arrays;

/**
 * @program: SwapNodePairs
 * @description:
 * @author: wangf-q
 * @date: 2022-03-01 00:31
 **/
public class SwapNodePairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead, pCur = head, pNext = head.next;
        while (pNext != null) {
            pre.next = pNext;
            pCur.next = pNext.next;
            pNext.next = pCur;
            pNext = pCur.next != null ? pCur.next.next : null;
            pre = pCur;
            pCur = pCur.next;
        }
        return dummyHead.next;
    }

    public static ListNode swapPairsptimize(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1, head);
        ListNode pCur = head, ret = head.next;
        while (pCur != null && pCur.next != null) {
            pre.next = pCur.next;
            pCur.next = pCur.next.next;
            pCur.next.next = pCur;
            pCur.next = pCur.next != null ? pCur.next.next : null;
            pre = pCur;
            pCur = pCur.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        final ListNode head1 = ListNode.generateList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode.printLinkedList(SwapNodePairs.swapPairs(head1));
        final ListNode head2 = ListNode.generateList(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListNode.printLinkedList(SwapNodePairs.swapPairs(head2));
    }
}
