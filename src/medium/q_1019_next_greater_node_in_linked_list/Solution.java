package medium.q_1019_next_greater_node_in_linked_list;

import easy.linkList.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Solution {
    public static int[] nextLargerNodes(ListNode head) {
        ListNode pN = head;
        int count = 0;
        while (pN != null) {
            count++;
            pN = pN.next;
        }

        pN = head;
        int[] result = new int[count];
        int index = 0;
        while (pN != null) {
            ListNode pt = pN.next;
            int largerVal = 0;
            while (pt != null) {
                if (pt.val > pN.val) {
                    largerVal = pt.val;
                    break;
                }
                pt = pt.next;
            }
            result[index++] = largerVal;
            pN = pN.next;
        }
        return result;
    }

    // 牛批解法
    // 解析： 相当于后面的数和前面的进行对比，如果后面的比前面的小就入栈，反之就遍历取出栈中所有对应的值
    // 巧妙的地方就是相当于栈的下标也是结果中的下标
    public static int[] nextLargeNodes2(ListNode head) {
        List<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        int[] result = new int[array.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.size(); i++) {
            while (!stack.isEmpty() && array.get(stack.peek()) < array.get(i)) {
                result[stack.pop()] = array.get(i);
            }
            stack.push(i);
        }
        return result;
    }


    public int[] nextLargerNodes3(ListNode head) {
        List<Integer> arrays = new ArrayList<>();
        while (head != null) {
            arrays.add(head.val);
            head = head.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arrays.size()];
        for (int i = 0; i < arrays.size(); i++) {
            while (!stack.isEmpty() && arrays.get(stack.peek()) < arrays.get(i)) {
                result[stack.pop()] = arrays.get(i);
            }
            stack.push(i);
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.geNerateLinkedList(Arrays.asList(2, 1, 5));
        int[] ints = nextLargeNodes2(head);
        for (int num : ints) {
            System.out.printf(num + " ,");
        }
    }


}