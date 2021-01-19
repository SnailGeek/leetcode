package medium.q_1669_merge_in_between_linked_lists;


import easy.linkList.common.ListNode;

import java.util.Arrays;

class Solution {
    // 暴力解法
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode pa = list1, pb = list1, tail = list2;
        int index = 0;
        while (index != b + 1) {
            if (index < a - 1) {
                pa = pa.next;
            }
            pb = pb.next;
            index++;
        }
        if (tail == null) {
            pa.next = pb;
        } else {
            while (tail.next != null) {
                tail = tail.next;
            }
            pa.next = list2;
            tail.next = pb;
        }
        return list1;
    }

    public static ListNode mergeInBetween2(ListNode list1, int a, int b, ListNode list2) {

        ListNode pa = list1, pb = list1;
        int index = 0;

        while (index != b + 1 || pa.next != null) {
            if (index != b + 1) {
                pb = pb.next;
                index++;
            }
            if (index == a) {
                pa.next = list2;
            } else if (pa.next != null) {
                pa = pa.next;
            }
        }
        pa.next = pb;
        return list1;
    }

    public static ListNode mergeInBetween3(ListNode list1, int a, int b, ListNode list2){
        if(list1 == null || list2 == null){
            return null;
        }
        ListNode slow,fast;
        slow=list1;
        fast=list1;
        int k=b-a+1;
        for(int i=0;i<k;i++)
            fast=fast.next;

        for(int i=1;i<a;i++)
        {
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=list2;
        while(list2.next!=null)
            list2=list2.next;

        list2.next=fast.next;

        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.geNerateLinkedList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        ListNode list2 = ListNode.geNerateLinkedList(Arrays.asList(1000000, 1000001, 1000002, 1000003, 1000004, 1000005, 1000006));
        ListNode.printLinkedList(mergeInBetween2(list1, 3, 5, list2));

    }
}