package medium.q_817;

import easy.linkList.common.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 这个题目中，是最长的链表是一个组件
public class Solution {
    public static int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet();
        for (int i : G) {
            set.add(i);
        }
        //转换成set的话查找速度要快一点，空间占用的回多一些
        ListNode pStart = head, pEnd = head;
        int count = 0;
        while (pEnd != null) {
            if (!set.contains(pEnd.val)) {
                if (pStart != pEnd) {
                    count++;
                }
                pStart = pEnd.next;
            }
            pEnd = pEnd.next;
        }
        if (pStart != pEnd) {
            count++;
        }
        return count;
    }

    // 如果用这个方法去查找元素的话，那么得到的结果占用空间比较少，由于暴力查找因此时间花费的多一些
    private static boolean containVal(int[] G, int val) {
        for (int i = 0; i < G.length; i++) {
            if (G[i] == val) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.geNerateLinkedList(Arrays.asList(0, 1, 2, 3));
        int[] G = {4};
        System.out.println(numComponents(head, G));
    }
}