package list.easy.q_23_merge_k_sorted_lists;

import list.common.ListNode;
import list.easy.q_21_merge_two_sorted_list.MergeTwoLists;

import java.util.Arrays;

/**
 * @program: MergeKSortedList
 * @description:
 * @author: wangf-q
 * @date: 2022-02-28 23:07
 **/
public class MergeKSortedList {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return doMergeKLists(lists, 0, lists.length);
    }

    private static ListNode doMergeKLists(ListNode[] lists, int fIndex, int lIndex) {
        if (lIndex - fIndex == 1) {
            return lists[fIndex];
        }
        ListNode left = doMergeKLists(lists, fIndex, (fIndex + lIndex + 1) / 2);
        ListNode right = doMergeKLists(lists, (fIndex + lIndex + 1) / 2, lIndex);
        return MergeTwoLists.mergeTwoLists(left, right);
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.generateList(Arrays.asList(1, 4, 5, 9));
        lists[1] = ListNode.generateList(Arrays.asList(2, 6));
        lists[2] = ListNode.generateList(Arrays.asList(2, 3, 7));
        ListNode.printLinkedList(mergeKLists(lists));
    }

}
