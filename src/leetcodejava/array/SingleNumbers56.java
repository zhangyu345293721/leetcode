package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 56 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 * 限制：
 * <p>
 * 2 <= nums <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SingleNumbers56 {

    @Test
    public void singleNumberTest() {
        int[] nums = {4, 1, 4, 5, 5, 6};
        int[] ints = singleNumbers2(nums);
        Assert.assertEquals(ints.length, 2);
    }

    /**
     * 找出只出现一次的数字
     *
     * @param nums 数组
     * @return 出现一次的数
     */
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length < 3) {
            return nums;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int a : set) {
            result[i++] = a;
        }
        return result;
    }

    /**
     * 找出只出现一次的数字
     *
     * @param nums 数组
     * @return 出现一次的数
     */
    public int[] singleNumbers2(int[] nums) {
        int sum = 0;
        // 得到异或结果，即为不相同两个数的异或结果sum
        for (int num : nums) {
            sum ^= num;
        }
        // 得到sum的二进制的1的最低位
        int flag = (-sum) & sum;
        int result[] = new int[2];
        // 分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
        for (int num : nums) {
            if ((flag & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
