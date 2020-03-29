package leetcodejava.array;


import org.junit.Test;

/**
 * This is the solution of No. 67 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-binary/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AddBinary67 {
    @Test
    public void addBinaryTest() {
        String a = "1010";
        String b = "1011";
        String sum = addBinary3(a, b);
        System.out.println(sum);
    }

    /**
     * 字符串相加(先将字符串转成十进制，再十进制相加减)
     *
     * @param a 字符串1
     * @param b 字符串2
     * @return 相加字符串
     */
    private String addBinary(String a, String b) {
        if (a == null || a.length() < 1) {
            return b;
        }
        if (b == null || b.length() < 1) {
            return a;
        }
        Integer integerA = Integer.valueOf(a, 2);
        Integer integerB = Integer.valueOf(b, 2);
        return Integer.toBinaryString(integerA + integerB);
    }

    /**
     * 字符串相加(直接位运算)
     *
     * @param a 字符串1
     * @param b 字符串2
     * @return 相加字符串
     */
    private String addBinary3(String a, String b) {
        if (a == null || a.length() < 1) {
            return b;
        }
        if (b == null || b.length() < 1) {
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int tempA = 0;
            int tempB = 0;
            if (i >= 0) {
                tempA = a.charAt(i) - '0';
            }
            if (j >= 0) {
                tempB = b.charAt(j) - '0';
            }
            carry += tempA + tempB;
            sb.append(carry % 2);
            i--;
            j--;
            carry = carry / 2;
        }
        if (carry > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
