
package easy.linkList.q_160_intersection_of_two_linked_lists;

import easy.linkList.common.ListNode;

import java.util.Arrays;

public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        int countA = 0, countB = 0;
        while (pA != null) {
            countA++;
            pA = pA.next;
        }
        while (pB != null) {
            countB++;
            pB = pB.next;
        }

        pA = headA;
        pB = headB;

        int i = countB - countA;
        if (i > 0) {
            while (i-- > 0) {
                pB = pB.next;
            }
        } else if (i < 0) {
            while (i++ < 0) {
                pA = pA.next;
            }
        }
        int startSameCount = 0;
        ListNode result = null;
        while (pA != null && pB != null) {
            if (pA == pB && startSameCount == 0) {
                result = pA;
                startSameCount++;
            }
            if (pA != pB) {
                result = null;
                startSameCount = 0;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return result;
    }

    // 诡异的写法，牛批！！！！！
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a.next == null ? headB : a.next;
            b = b.next == null ? headA : b.next;
        }

        return a;
    }


    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        //统计链表A和链表B的长度
        int lenA = length(headA), lenB = length(headB);

        //如果节点长度不一样，节点多的先走，直到他们的长度一样为止
        while (lenA != lenB) {
            if (lenA > lenB) {
                //如果链表A长，那么链表A先走
                headA = headA.next;
                lenA--;
            } else {
                //如果链表B长，那么链表B先走
                headB = headB.next;
                lenB--;
            }
        }

        //然后开始比较，如果他俩不相等就一直往下走
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        //走到最后，最终会有两种可能，一种是headA为空，
        //也就是说他们俩不相交。还有一种可能就是headA
        //不为空，也就是说headA就是他们的交点
        return headA;
    }

    //统计链表的长度
    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }



    public static void main(String[] args) {
        //5,6,1,8,4,5
        ListNode head = ListNode.geNerateLinkedList(Arrays.asList(4, 1, 8, 4, 5));
        ListNode head2 = ListNode.geNerateLinkedList(Arrays.asList(5, 6, 1, 8, 4, 5));
        ListNode.printLinkedList(getIntersectionNode(head, head2));
    }
}