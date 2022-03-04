package list.hard.q_25_reverse_nodes_in_k_group;

import list.common.ListNode;

/**
 * @program: ReverseNodesInKGroup
 * @description:
 * @author: wangf-q
 * @date: 2022-03-02 12:35
 **/
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode lastTail = dummy, tail = head;
        while (tail != null) {
            int i = 0;
            if (i < k) {


            }
            tail = tail.next;
        }
    }

    private static ListNode reverseNode(ListNode pre, ListNode start, ListNode tail) {
        ListNode behind = tail;
        ListNode nextPre = start;
        while (start != tail) {
            ListNode tmp = start.next;
            start.next = behind;
            behind = start;
            pre.next = behind;
            start = tmp;
        }
        pre = nextPre;
        return behind;
    }


    public static void main(String[] args) {

    }
}
