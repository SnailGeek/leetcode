package easy.linkList.q_1290;


import easy.linkList.common.ListNode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public static int getDecimalValue(ListNode head) {
        ListNode tail = new ListNode(head.val, head.next);
        int num = 0;
        while (tail.next != null) {
            num++;
            tail = tail.next;
        }
        int result = 0;
        ListNode p = head;
        for (int i = num; i >= 0; i--) {
            result += p.val * Math.pow(2, i);
            p = p.next;
        }
        return result;
    }

    public static int getApproach2(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;
        }
        return num;
    }


    public static void main(String[] args) {
        System.out.println(getDecimalValue(ListNode.generateList(Arrays.asList(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0))));
        System.out.println(getApproach2(ListNode.generateList(Arrays.asList(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0))));
    }
}

