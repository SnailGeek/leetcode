import java.util.ArrayList;
import java.util.List;

/**
 * @program: MergeTwoSortedLists
 * @description:
 * @author: wangf-q
 * @date: 2020-05-27 13:07
 **/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resHeader = null;
        ListNode pNode = new ListNode();
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pNode.next = new ListNode(l2.val);
                if (resHeader == null) {
                    resHeader = pNode;
                }
                pNode = pNode.next;
                l2 = l2.next;
            } else if (l2 == null) {
                pNode.next = new ListNode(l1.val);
                if (resHeader == null) {
                    resHeader = pNode;
                }
                pNode = pNode.next;
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    pNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    pNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                if (resHeader == null) {
                    resHeader = pNode;
                }
                pNode = pNode.next;
            }

        }
        return resHeader == null ? null : resHeader.next;
    }

    public static void main(String[] args) {
//        List<Integer> l1List = Arrays.asList(1, 2, 3, 4);
//        List<Integer> l2List = Arrays.asList(1, 2, 5);

        List<Integer> l1List = new ArrayList<>();
        List<Integer> l2List = new ArrayList<>();

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = mergeTwoSortedLists.getLisNode(l1List);
        ListNode l2 = mergeTwoSortedLists.getLisNode(l2List);
        ListNode newList = mergeTwoSortedLists.mergeTwoLists(l1, l2);


        while (newList != null) {
            System.out.printf(newList.val + ",");
            newList = newList.next;
        }
        System.out.println();

    }

    public ListNode getLisNode(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        ListNode result = new ListNode(list.get(0));
        ListNode p = result;
        for (int i = 1; i < list.size(); i++) {
            p.next = new ListNode(list.get(i));
            p = p.next;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }


}
