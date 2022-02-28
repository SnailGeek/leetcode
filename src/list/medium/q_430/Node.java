package list.medium.q_430;

import java.util.List;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public static Node generateNodeList(List<Integer> nums) {
        Node head = new Node(1);
        for (int i = 0; i < nums.size(); i++) {
            Node pNode = new Node(nums.get(i));
            head.next = pNode;
            if (i == 1) {
                pNode.child = new Node(9);
                pNode.child.next = new Node(10);
            }
            pNode = pNode.next;
        }
        return head;
    }
};