package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SingleNumber56
 * @description:
 * @author: wangf-q
 * @date: 2021-02-24 14:00
 **/
public class SingleNumber56 {

    /**
     * 普通解法
     *
     * @param nums
     * @return
     */
    public static int singleNumberForMap(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : nums) {
            if (numCountMap.containsKey(num)) {
                numCountMap.put(num, -1);
            } else {
                numCountMap.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int singleNumberForBit(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += num & 1;
                num = num >>> 1;
            }
        }
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // 左移相当于乘 2
            result <<= 1;
            result |= (bits[31 - i] % 3);
        }
        return result;
    }

    public static int singleNumber(int[] nums) {
        // 具体思路由某一位有三种状态的变化规律，进而推出32位数中，其他所有位数字的规律
        // 具体的推导过程，可以看看leetCode答案
        // 为什么最终结果不是00 就是 01 可以看下面的解释
        // 如果n为3个0，一个1， 初始化状态为two=0 , one=0
        //  n|two one
        //  0|0    0
        //  0|0    0
        //  0|0    0
        //  1|0	   1

        //如果n为3个1，一个0， 初始化状态为two=0 , one=0
        //  n|two one
        //  1|0    1
        //  1|1    0
        //  1|0    0
        //  0|0	   0
        // 可以看到上面两种情况下，最终结果就是00 或者01 因此one 代表的是最终的结果
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2};
        System.out.println(singleNumberForBit(nums));
    }

}
