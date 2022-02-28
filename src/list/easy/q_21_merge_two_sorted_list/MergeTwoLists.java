package list.easy.q_21_merge_two_sorted_list;

import list.common.ListNode;

import java.util.Arrays;

/**
 * @program: MergeTwoLists
 * @description:
 * @author: wangf-q
 * @date: 2022-02-28 22:00
 **/
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode pNode = dummyHead;
        while (list1 != null || list2 != null) {
            if (list2 == null || list1 != null && list1.val < list2.val) {
                pNode.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                pNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            pNode = pNode.next;
        }
        return dummyHead.next;
    }


    public static ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummyHead;
        if (list1.val < list2.val) {
            dummyHead = new ListNode(list1.val);
            dummyHead.next = mergeTwoLists(list1.next, list2);
        } else {
            dummyHead = new ListNode(list2.val);
            dummyHead.next = mergeTwoLists(list1, list2.next);
        }
        return dummyHead;
    }


    /**
     * 递归优化版，少申请一个变量
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoListsRecursion2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.generateList(Arrays.asList(1, 3, 5));
        ListNode list2 = ListNode.generateList(Arrays.asList(2, 4, 6, 8));
        ListNode.printLinkedList(MergeTwoLists.mergeTwoListsRecursion(list1, list2));

    }
}
