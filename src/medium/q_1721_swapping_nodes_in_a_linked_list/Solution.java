package medium.q_1721_swapping_nodes_in_a_linked_list;

import easy.linkList.common.ListNode;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, slow = head, first = head, second = head;
        for (int i = 0; i < k - 1; i++){
            fast = fast.next;
        }
        first = fast;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        second = slow;

        int tmpVal = first.val;
        first.val = second.val;
        second.val = tmpVal;
        return head;
    }
    // 今天时间不多了，如果有时间可以挑战一下，不是通过值交换，而是真正的实现节点交换

    public static void main(String[] args) {
        ListNode head = ListNode.geNerateLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListNode.printLinkedList(swapNodes(head, 2));
    }
}