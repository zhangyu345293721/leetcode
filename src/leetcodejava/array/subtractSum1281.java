package leetcodejava.array;

import org.junit.Test;

/**
 * 计算差
 *
 * @author: zhangyu
 */
public class subtractSum1281 {
    @Test
    public void testSubtractSum() {
        int n = 4421;
        int sub = subtractProductAndSum(n);
        System.out.println(sub);
    }

    /**
     * 计算差
     *
     * @param n 输入数字
     * @return 返回差
     */
    public int subtractProductAndSum(int n) {
        if (n < 0) {
            return -1;
        }
        char[] chs = String.valueOf(n).toCharArray();
        int multiply = getMultiply(chs);
        int sum = getSum(chs);
        return multiply - sum;
    }

    /**
     * 求和
     *
     * @param chs 字符数组
     * @return 求和
     */
    private int getSum(char[] chs) {
        int sum = 0;
        for (char ch : chs) {
            int num = ch - '0';
            sum += num;
        }
        return sum;
    }

    /**
     * 计算字符串的乘积
     *
     * @param chs 字符数组
     * @return 乘积
     */
    private int getMultiply(char[] chs) {
        int multiply = 1;
        for (char ch : chs) {
            int num = ch - '0';
            multiply *= num;
        }
        return multiply;
    }
}
