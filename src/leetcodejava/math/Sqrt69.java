package leetcodejava.math;

import org.junit.Assert;
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
 * <p>
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Sqrt69 {

    @Test
    public void sqrtTest() {
        int num = 8;
        int result = mySqrt3(num);
        System.out.println(result);
        Assert.assertEquals(result, 2);
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
        int result = 1;
        while (result <= x / result) {
            result++;
        }
        return result - 1;
    }

    /**
     * 对数字进行开方(利用二分查找)
     *
     * @param x 数字
     * @return 整数
     */
    public int mySqrt3(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0, right = x, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 防止溢出mid*mid溢出
            if (mid <= x / mid) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
