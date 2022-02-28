package list.easy.q_234_palindrome_linked_list;


import list.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode pre = head, pNext = head.next;
        List<Integer> value = new ArrayList<>();
        value.add(head.val);
        while (pNext != null) {
            pre.next = pNext.next;
            pNext.next = head;
            head = pNext;
            pNext = pre.next;
            value.add(head.val);
        }
        ListNode pNode = head;
        for (int v : value) {
            if (v != pNode.val) {
                return false;
            }
            pNode = pNode.next;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode pSlow = head, pFast = head;
        while(pFast != null && pFast.next != null){
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        ListNode pMiddleHead = reverse(pSlow);
        while (head != pSlow && pMiddleHead != null){
            if (head.val != pMiddleHead.val){
                return false;
            }
            head = head.next;
            pMiddleHead = pMiddleHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generateList(Arrays.asList(1, 2));
        System.out.println(isPalindrome2(head));
    }
    public static ListNode reverse(ListNode head){
        ListNode pre = head, pNext = head.next;
        while (pNext != null) {
            pre.next = pNext.next;
            pNext.next = head;
            head = pNext;
            pNext = pre.next;
        }
        return head;
    }
}