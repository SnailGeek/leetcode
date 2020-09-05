package easy.q_27_remove_element;

import java.util.Arrays;

/**
 * @program: RemoveElement
 * @description:
 * @author: wangf-q
 * @date: 2020-06-19 17:12
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int indexVal = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (indexVal == -1) {
                    indexVal = i;
                }
            } else {
                if (indexVal != -1) {
                    nums[indexVal] = nums[i];
                    indexVal++;
                }
            }
        }
        return indexVal == -1 ? nums.length : indexVal;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = {1, 3, 4};
        int i = re.removeElement(nums, 3);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}
