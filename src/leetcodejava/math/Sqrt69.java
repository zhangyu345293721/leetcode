package leetcodejava.math;

import org.junit.Test;

/**
 * This is the solution of No. 69 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sqrtx
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Sqrt69 {

    @Test
    public void sqrtTest() {
        int num = 8;
        int i = mySqrt(num);
        System.out.println(i);
    }

    /**
     * 对数字进行开放
     *
     * @param x 数字
     * @return 整数
     */
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    /**
     * 对数字进行开方
     *
     * @param x 数字
     * @return 整数
     */
    public int mySqrt2(int x) {
        if (x <= 1) {
            return x;
        }
        long i = 1;
        while (i * i <= x) {
            i++;
        }
        return (int) (i - 1);
    }

}
