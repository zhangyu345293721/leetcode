package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 258 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-digits/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AddDigits258 {

    @Test
    public void addDigitsTest() {
        int num = 38;
        int result = addDigits2(num);
        Assert.assertEquals(result, 2);
    }

    /**
     * 计算一个数到个位
     *
     * @param num 数num
     * @return 各位数的和
     */
    public int addDigits(int num) {
        int total = 0;
        while (num > 0) {
            int leftNumber = num % 10;
            total += leftNumber;
            num = num / 10;
        }
        if (total < 10) {
            return total;
        } else {
            return addDigits(total);
        }
    }

    /**
     * 计算一个数到个位
     *
     * @param num 数num
     * @return 各位数的和
     */
    public int addDigits2(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}
