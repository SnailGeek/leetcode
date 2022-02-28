package list.easy.q_26_remove_duplicates;

import java.util.Arrays;

/**
 * @program: RemoveDuplicates
 * @description:
 * @author: wangf-q
 * @date: 2020-06-16 12:32
 **/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] result = new int[nums.length];
        int preNum = 0;
        int sameIntCount = 0;
        int resultIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != preNum) {
                result[resultIndex++] = nums[i];
                preNum = nums[i];
            } else {
                sameIntCount++;
            }
        }
        for (int i = 0; i < result.length - sameIntCount; i++) {
            nums[i] = result[i];
        }
        return result.length - sameIntCount;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = 1;
        for (; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                if (j - i != 1) {
                    nums[++i] = nums[j];
                } else {
                    ++i;
                }
            }
        }
        return j - i == 1 ? nums.length : i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates rm = new RemoveDuplicates();
        int[] nums = {1, 1, 3};
        System.out.println(rm.removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }
}
