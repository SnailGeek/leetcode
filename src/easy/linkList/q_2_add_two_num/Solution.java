package q_2_add_two_num;

import easy.linkList.common.ListNode;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode resultList = null;
        ListNode pNode = resultList;
        Integer sumMoreThanTen = 0;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 == null) {
                val = l2.val + sumMoreThanTen;
                if (val >= 10) {
                    val = val - 10;
                } else {
                    sumMoreThanTen = 0;
                }
                pNode.next = new ListNode(val);
                pNode = pNode.next;
                l2 = l2.next;
            } else if (l2 == null) {
                val = l1.val + sumMoreThanTen;
                if (val >= 10) {
                    val = val - 10;
                } else {
                    sumMoreThanTen = 0;
                }
                pNode.next = new ListNode(val);
                pNode = pNode.next;
                l1 = l1.next;
            } else {
                val = l1.val + l2.val + sumMoreThanTen;
                if (val >= 10) {
                    val = val - 10;
                    sumMoreThanTen = 1;
                } else {
                    sumMoreThanTen = 0;
                }
                if (pNode == null) {
                    resultList = new ListNode(val);
                    pNode = resultList;
                } else {
                    pNode.next = new ListNode(val);
                    pNode = pNode.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if (sumMoreThanTen != 0) {
            pNode.next = new ListNode(sumMoreThanTen);
        }

        return resultList;
    }

    public ListNode addTwoNumbersEz(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, pCur = resHead;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int val1 = p1 != null ? p1.val : 0;
            int val2 = p2 != null ? p2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            pCur.next = new ListNode(sum % 10);
            pCur = pCur.next;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }
        if (carry != 0){
            pCur.next = new ListNode(carry);
        }
        return resHead.next;
    }

    public ListNode transList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        ListNode pCur = head;
        ListNode pNext = head.next;
        while (pCur != null) {
            pCur.next = newHead.next;
            newHead.next = pCur;
            pCur = pNext;
            if (pNext != null) {
                pNext = pNext.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode demoHead = s.testDemo(Arrays.asList(1));
//        s.printList(demoHead);
        ListNode demoHead2 = s.testDemo(Arrays.asList(9, 9));
//        s.printList(demoHead2);
        ListNode result = s.addTwoNumbersEz(demoHead, demoHead2);

        s.printList(result);

    }

    public ListNode testDemo(List<Integer> list) {
        ListNode head = null;
        ListNode pNode = head;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                head = new ListNode(list.get(0));
                pNode = head;
            } else {
                pNode.next = new ListNode(list.get(i));
                pNode = pNode.next;
            }
        }
        return head;
    }

    public void printList(ListNode head) {
        ListNode pNode = head;
        while (pNode != null) {
            System.out.println("node: " + pNode.val);
            pNode = pNode.next;
        }
    }

    public Integer getCount(ListNode head) {
        Integer result = 0;
        ListNode pNode = head;
        while (pNode != null) {
            result += pNode.val;
            pNode = pNode.next;
        }
        return result;
    }
}