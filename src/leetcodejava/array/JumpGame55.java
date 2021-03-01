package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 55 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/jump-game/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class JumpGame55 {
    @Test
    public void jumpGameTest() {
        int[] nums = {3, 2, 1, 0, 4};
        boolean flag = jumpGame2(nums);
        Assert.assertEquals(flag, false);
    }

    /**
     * 跳步游戏
     *
     * @param nums 数组
     * @return 布尔值
     */
    private boolean jumpGame1(int[] nums) {
        if (nums.length < 1) {
            return true;
        }
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 跳步游戏
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean jumpGame2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums == null || nums[0] == 0) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                boolean flag = jumpFlag(nums, i);
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断是否能跳过0
     *
     * @param nums 数组
     * @param i    位置
     * @return 布尔值
     */
    private boolean jumpFlag(int[] nums, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] > i - j) {
                return true;
            }
        }
        return false;
    }
}
