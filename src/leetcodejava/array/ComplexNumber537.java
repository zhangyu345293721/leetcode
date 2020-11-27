package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 537 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/complex-number-multiplication/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个表示复数的字符串。
 * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1+1i", "1+1i"
 * 输出: "0+2i"
 * 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2:
 * <p>
 * 输入: "1+-1i", "1+-1i"
 * 输出: "0+-2i"
 * 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 * 注意:
 * <p>
 * 输入字符串不包含额外的空格。
 * 输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ComplexNumber537 {
    @Test
    public void complexNumberTest() {
        String a = "-11+-30i";
        String b = "55+-69i";
        String result = complexNumberMultiply(a, b);
        Assert.assertEquals(result, "-2675+-891i");

    }

    /**
     * 复数相乘
     *
     * @param a 字符串a
     * @param b 字符串b
     * @return 字符串
     */
    public String complexNumberMultiply(String a, String b) {
        int i1 = a.indexOf('+');
        int i2 = a.indexOf('i');
        int j1 = b.indexOf('+');
        int j2 = b.indexOf('i');

        int a1 = Integer.parseInt(a.substring(0, i1));
        int b1 = Integer.parseInt(a.substring(i1 + 1, i2));
        int a2 = Integer.parseInt(b.substring(0, j1));
        int b2 = Integer.parseInt(b.substring(j1 + 1, j2));

        int aa = a1 * a2 - b1 * b2;
        int bb = a1 * b2 + a2 * b1;

        return aa + "+" + bb + "i";
    }
}
