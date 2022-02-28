package list.common;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode generateList(List<Integer> nums) {
        ListNode head = new ListNode(nums.get(0), null);
        ListNode p = head;
        for (int i = 1; i < nums.size(); i++) {
            p.next = new ListNode(nums.get(i));
            p = p.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.print(',');
            head = head.next;
        }
        System.out.println();
    }
}