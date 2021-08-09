package leetcodejava.string;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 415 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-strings
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AddString415 {

    @Test
    public void addStringTest() {
        String num1 = "12345";
        String num2 = "12345";
        String num = addStr(num1, num2);
        Assert.assertEquals(num, "24690");
    }

    /**
     * 加字符串
     *
     * @param num1 字符串1
     * @param num2 字符串2
     * @return 字符串和
     */
    public String addStr(String num1, String num2) {
        if (num1 == null || num1.length() < 1) {
            return num2;
        }
        if (num2 == null || num2.length() < 1) {
            return num1;
        }
        StringBuffer sb = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int total = carry;
            if (i >= 0) {
                total += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                total += num2.charAt(j--) - '0';
            }
            carry = total / 10;
            sb.append(total % 10);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
