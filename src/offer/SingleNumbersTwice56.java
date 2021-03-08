package offer;

/**
 * @program: SingleNumbers56
 * @description:
 * @author: wangf-q
 * @date: 2021-03-06 16:56
 **/
public class SingleNumbersTwice56 {
    public static int[] singleNumbers(int[] nums) {
        int ret = 0;
        // 所有数字取异或所得结果即为不同数字的异或结果，因为相同数字异或结果为0
        for (int num : nums) {
            ret ^= num;
        }

        // 从结果中找到第一个二进制为1的位置
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            // 将nums中的数字进行分组，可以将不同的两个数字分到不同的组里
            // 因为上面ret的二进制位为1的地方，两个数字对应的二进制位肯定是不同的，否则异或结果就是0了
            if ((div & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] result = singleNumbers(new int[]{4, 1, 4, 6});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
