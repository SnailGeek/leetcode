package list.easy.q_206_reverse_linked_list;

import list.common.ListNode;

import java.util.Arrays;

/**
 * @program: ReverseList
 * @description:
 * @author: wangf-q
 * @date: 2022-03-01 12:31
 **/
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1, head);
        ListNode preNode = head, pNext = head.next;
        while (pNext != null) {
            preNode.next = pNext.next;
            pNext.next = dummyHead.next;
            dummyHead.next = pNext;
            pNext = preNode.next;
        }
        return dummyHead.next;
    }


    /**
     * 该解法的思想是原链表遍历取出，头插到新链表，其中behind为新链表的表头
     * 例子：1->2->3->4->5
     * 第一次循环: (behind)1->null (head)2->3->4->5
     * 第二次循环: (behind)2->1->null (head)3->4->5
     * ...
     * 最终：5->4->3->2->1
     *
     * @param head
     * @return
     */
    public static ListNode reverseListOptimize(ListNode head) {
        ListNode behind = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = behind;
            behind = head;
            head = next;
        }
        return behind;
    }

    /**
     * 递归的解法思路是从后往前进行转换
     * 例子：1->2->3->4->5
     * 递归一直到中止条件找到新的头节点：5
     * 返回至上一层，此时head为4，执行之后的逻辑链表变为：1->2->3->4<-5 ,其中4->null
     * 以此类推最终翻转了链表
     * 【注意】，最后需要将1->null 否则会出现环
     *
     * @param head
     * @return
     */
    public static ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        final ListNode head1 = ListNode.generateList(Arrays.asList(1, 2));
        final ListNode head2 = ListNode.generateList(Arrays.asList(1, 2, 3));
        final ListNode head3 = ListNode.generateList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode.printLinkedList(ReverseList.reverseListByRecursion(head1));
        ListNode.printLinkedList(ReverseList.reverseListByRecursion(head2));
        ListNode.printLinkedList(ReverseList.reverseListByRecursion(head3));
    }
}
