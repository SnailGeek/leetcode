package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: CopyRandomList35
 * @description:
 * @author: wangf-q
 * @date: 2021-03-04 08:58
 **/
public class CopyRandomList35 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> oldCopyNodeMap = new HashMap<>();
        return doCopy(head, oldCopyNodeMap);
    }

    // 深度优先遍历方法，利用递归，将创建的节点放在map中，后面random再从map中取出
    private Node doCopy(Node node, Map<Node, Node> oldCopyNodeMap) {
        if (node == null) {
            return node;
        }
        Node copy = new Node(node.val);
        if (oldCopyNodeMap.containsKey(node)) {
            return oldCopyNodeMap.get(node);
        }
        oldCopyNodeMap.put(node, copy);
        copy.next = doCopy(node.next, oldCopyNodeMap);
        copy.random = doCopy(node.random, oldCopyNodeMap);
        return copy;
    }


    /**
     * 占用空间较小的方法，先将原来节点再原来链表中复制一下，然后再将random节点关联起来，最后将完成之后的节点拆出来
     * @param head
     * @return
     */
    public Node copyRandomListBetter(Node head) {
        if (head == null) {
            return null;
        }
        Node pNode = head;
        while (pNode != null) {
            Node newNode = new Node(pNode.val);
            newNode.next = pNode.next;
            pNode.next = newNode;
            pNode = newNode.next;
        }
        pNode = head;
        while (pNode != null && pNode.next != null) {
            pNode.next.random = pNode.random == null ? null : pNode.random.next;
            pNode = pNode.next.next;
        }
        Node pOld = head, pNew = head.next, retHead = head.next;
        while (pOld != null && pOld.next != null) {
            pOld.next = pNew.next;
            if (pNew.next != null) {
                pNew.next = pOld.next.next;
            }
            pOld = pOld.next;
            pNew = pNew.next;
        }
        return retHead;
    }

    public static void main(String[] args) {

    }


    /**
     * Definition for a Node.
     */
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}



