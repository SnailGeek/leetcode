package list.easy.q_237_delete_node_in_a_linked_list;

import list.common.ListNode;

import java.util.Arrays;


public class Solution {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next == null ? null : node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generateList(Arrays.asList(1, 2));
        ListNode p = head.next;
        deleteNode(p);
        ListNode.printLinkedList(head);
    }
}