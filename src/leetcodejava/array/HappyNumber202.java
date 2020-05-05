package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 202 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/happy-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class HappyNumber202 {

    @Test
    public void happyNumberTest() {
        int n = 19;
        boolean flag = isHappy(n);
        System.out.println(flag);
    }

    /**
     * 判断一个数是不是快乐数
     *
     * @param n 数字
     * @return 布尔值
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = countSquareSum(n);
        while (slow != fast) {
            slow = countSquareSum(slow);
            fast = countSquareSum(countSquareSum(fast));
        }
        return slow == 1;
    }

    /**
     * 一个数计算它的每位数字平方
     *
     * @param n 数字
     * @return 平方和
     */
    private int countSquareSum(int n) {
        int total = 0;
        while (n > 0) {
            int num = n % 10;
            total += num * num;
            n = n / 10;
        }
        return total;
    }
}
