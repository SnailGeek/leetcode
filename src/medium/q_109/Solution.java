package medium.q_109;

import easy.linkList.common.ListNode;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public ListNode getMedium(ListNode left, ListNode right) {
        ListNode slow = left, fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode medium = getMedium(left, right);
        TreeNode root = new TreeNode(medium.val);
        root.left = buildTree(left, medium);
        root.right = buildTree(medium.next, right);
        return root;
    }
}

