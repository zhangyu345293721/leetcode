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
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 *  
 * 示例 1:
 *
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * 示例 1:
 *
 * 输入: num = 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
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
        if (num == 0) {
            return 0;
        }
        int total = 0;
        while (num != 0) {
            total += num % 10;
            num = num / 10;
        }
        return total < 10 ? total : addDigits(total);
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
