package leetcodejava.math;// package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No. 66 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/plus-one
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

public class PlusOne66 {

    @Test
    public void plusOneTest() {
        int[] digits = {8, 9};
        int[] result = plusOne(digits);
        System.out.println(result);
        Assert.assertArrayEquals(result, new int[]{9, 0});
    }

    /**
     * 数组进行加1操作
     *
     * @param digits 数字数组
     * @return 数组
     */
    private int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1) {
            return new int[0];
        }
        int count = 1;
        int i = digits.length - 1;
        List<Integer> list = new ArrayList<>();
        while (i >= 0) {
            int sum = digits[i] + 1;
            if (count == 1) {
                if (sum > 9) {
                    list.add(0, 0);
                } else {
                    list.add(0, sum);
                    count = 0;
                }
            } else {
                list.add(0, sum);
            }
            i--;
        }
        if (count == 1) {
            list.add(0, 1);
        }
        return list.stream().mapToInt(e -> e.intValue()).toArray();
    }

    /**
     * 数组进行加1操作
     *
     * @param digits 数字数组
     * @return 数组
     */
    private int[] plusOne2(int[] digits) {
        if (digits == null) {
            return new int[0];
        }
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[length + 1];
        result[0] = 1;
        return result;
    }
}
