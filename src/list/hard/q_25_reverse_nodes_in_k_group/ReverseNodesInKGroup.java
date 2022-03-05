package list.hard.q_25_reverse_nodes_in_k_group;

import list.common.ListNode;

import java.util.Arrays;

/**
 * @program: ReverseNodesInKGroup
 * @description:
 * @author: wangf-q
 * @date: 2022-03-02 12:35
 **/
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode lastTail = dummy, pre = dummy, tail = head;
        int i = 0;
        while (tail != null) {
            if (i == k) {
                i = 0;
                pre = lastTail;
                ListNode behind = tail;
                while (head != tail) {
                    ListNode tmp = head.next;
                    head.next = behind;
                    behind = head;
                    pre.next = behind;
                    head = tmp;
                    if (behind.next == tail) {
                        lastTail = behind;
                    }
                }
                pre = lastTail;
            }
            i++;
            tail = tail.next;
        }
        if (i == k) {
            ListNode behind = tail;
            while (head != tail) {
                ListNode tmp = head.next;
                head.next = behind;
                behind = head;
                pre.next = behind;
                head = tmp;
            }
        }
        return dummy.next;
    }


    /**
     * 官方解法
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroupOfficial(ListNode head, int k) {
        ListNode hair = new ListNode(-1, head);
        ListNode pre = hair;
        while (pre != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            ListNode nex = tail.next;
            final ListNode[] reverse = myreverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    private static ListNode[] myreverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }

    /**
     * 大神的递归解法
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroupByRecursion(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) {
                return head;
            }
            node = node.next;
        }
        final ListNode newHead = reverse(head, node);
        head.next = reverseKGroupByRecursion(node, k);
        return newHead;
    }

    private static ListNode reverse(ListNode first, ListNode last) {
        ListNode prev = last;
        while (first != last) {
            ListNode tmp = first.next;
            first.next = prev;
            prev = first;
            first = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        final ListNode head = ListNode.generateList(Arrays.asList(1, 2, 3, 4, 5, 6));
        final ListNode head1 = ListNode.generateList(Arrays.asList(1, 2, 3, 4, 5));
        final ListNode head2 = ListNode.generateList(Arrays.asList(1, 2, 3, 4, 5));
        final ListNode head3 = ListNode.generateList(Arrays.asList(1, 2));

        ListNode.printLinkedList(ReverseNodesInKGroup.reverseKGroupByRecursion(head, 3));
        ListNode.printLinkedList(ReverseNodesInKGroup.reverseKGroupByRecursion(head1, 2));
        ListNode.printLinkedList(ReverseNodesInKGroup.reverseKGroupByRecursion(head2, 1));
        ListNode.printLinkedList(ReverseNodesInKGroup.reverseKGroupByRecursion(head3, 2));
    }
}
