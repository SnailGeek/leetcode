package list.easy.q_2_add_two_num;

import list.common.ListNode;

import java.util.Arrays;

/**
 * @program: AddTwoNumbers
 * @description:
 * @author: wangf-q
 * @date: 2022-02-28 20:36
 **/
public class AddTwoNumbers {


    /**
     * 内存空间优化的地方，可以不用额外审批遍历的节点pNode1, pNode2
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l1;
        }
        if (l2 == null) {
            return l2;
        }
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode pNode = head;
        while (l1 != null || l2 != null || carry != 0) {
            final int sum = (l1 == null ? 0 : l1.val) +
                    (l2 == null ? 0 : l2.val) + carry;
            pNode.next = new ListNode(sum % 10);
            carry = sum / 10;
            pNode = pNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        final ListNode l1 = ListNode.generateList(Arrays.asList(9, 9, 9, 9));
        final ListNode l2 = ListNode.generateList(Arrays.asList(9, 9, 9));
        ListNode.printLinkedList(AddTwoNumbers.addTwoNumbers(l1, l2));
    }
}
