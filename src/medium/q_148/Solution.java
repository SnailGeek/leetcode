package medium.q_148;

import easy.linkList.common.ListNode;

import java.util.Arrays;

public class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode medium = getMedium(head, tail);
        ListNode leftHead = sortList(head, medium);
        ListNode rightHead = sortList(medium, tail);
        return merge(leftHead, rightHead);
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode pl = leftHead, pr = rightHead;
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        while (pl != null && pr != null) {
            if (pl.val <= pr.val) {
                p.next = pl;
                p = p.next;
                pl = pl.next;
            } else if (pl.val > pr.val) {
                p.next = pr;
                p = p.next;
                pr = pr.next;
            }
        }
        if (pl != null) {
            p.next = pl;
        } else if (pr != null) {
            p.next = pr;
        }
        return ret.next;
    }

    public ListNode getMedium(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        ListNode.printLinkedList(so.sortList(ListNode.geNerateLinkedList(Arrays.asList(4, 2, 1, 3))));
    }
}