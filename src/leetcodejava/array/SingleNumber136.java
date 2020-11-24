package leetcodejava.array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 136 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/single-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SingleNumber136 {

    @Test
    public void singleNumberTest() {
        int[] arr = {2, 3, 3, 2, 4};
        int num = singleNumer1(arr);
        System.out.println(num);
    }

    /**
     * 获取单个数
     *
     * @param nums 数组
     * @return 单个数
     */
    private int singleNumer1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int ele : nums) {
            if (set.contains(ele)) {
                set.remove(ele);
            } else {
                set.add(ele);
            }
        }
        return (int) set.toArray()[0];
    }

    /**
     * 获取单个数
     *
     * @param nums 数组
     * @return 单个数
     */
    private int singleNumer2(int[] nums) {
        int singleNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            singleNumber ^= nums[i];
        }
        return singleNumber;
    }
}
