package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 306 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/additive-number/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * <p>
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * <p>
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * <p>
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 * <p>
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AdditiveNumber306 {

    @Test
    public void additiveNumberTest() {
        String str = "0235813";
        boolean result = isAdditiveNumber(str);
        System.out.println(result);
        Assert.assertEquals(result, false);
    }

    private boolean flag = false;

    /**
     * 判断是不是累加数
     *
     * @param num 数字符串
     * @return 布尔值
     */
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        int length = num.length();
        int i = 0;
        for (int j = 1; j < length; j++) {
            for (int k = j + 1; k < length; k++) {
                helper(i, j, k, num);
                if (flag) {
                    return flag;
                }
            }
        }
        return flag;
    }

    /**
     * 累加数帮助类
     *
     * @param i   下标i
     * @param j   下标j
     * @param k   下标k
     * @param num 字符串
     */
    private void helper(int i, int j, int k, String num) {
        if (num.charAt(i) == '0' && j - i > 1) {
            return;
        }
        if (num.charAt(j) == '0' && k - j > 1) {
            return;
        }
        Long num1 = Long.valueOf(num.substring(i, j));
        Long num2 = Long.valueOf(num.substring(j, k));
        long total = num1 + num2;
        if (k >= num.length()) {
            flag = true;
            return;
        }
        int length = String.valueOf(total).length();
        int end = k + length;
        if (end > num.length()) {
            return;
        }
        if (Long.valueOf(num.substring(k, end)) != total) {
            return;
        }
        helper(j, k, end, num);
    }
}
