package list.medium.q_430;

import java.util.Arrays;

public class Solution {
    public Node flatten(Node head) {
        linkChildNode(head);
        return head;
    }

    public Node linkChildNode(Node head) {
        Node pNode = head;
        if (pNode.next == null) {
            return pNode;
        }
        while (pNode.next != null) {
            if (pNode.child != null) {
                flatten(pNode.child).next = pNode.next;
                pNode.next = pNode.child;
            }
            pNode = pNode.next;
        }
        return pNode;
    }

    public static void main(String[] args) {
        Node node = Node.generateNodeList(Arrays.asList(2, 3, 4, 5, 6));

    }

}