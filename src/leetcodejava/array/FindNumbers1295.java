package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 1295 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 *
 * 示例 1：
 *
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数） 
 * 345 是 3 位数字（位数为奇数）  
 * 2 是 1 位数字（位数为奇数） 
 * 6 是 1 位数字 位数为奇数） 
 * 7896 是 4 位数字（位数为偶数）  
 * 因此只有 12 和 7896 是位数为偶数的数字
 * 示例 2：
 *
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindNumbers1295 {
    @Test
    public void testFindNumber() {
        int[] nums = {12, 345, 2, 6, 7896};
        int count = findNumbers(nums);
        System.out.println(count);
    }

    /**
     * 寻找数字
     *
     * @param nums 数组
     * @return 寻找数字
     */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
