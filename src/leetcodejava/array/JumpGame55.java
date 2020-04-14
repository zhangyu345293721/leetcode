package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 55 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/jump-game/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class JumpGame55 {
    @Test
    public void testJumpGame() {
        int[] nums = {3, 2, 1, 0, 4};
        boolean flag = canJump3(nums);
        System.out.println(flag);
    }

    /**
     * 能跳
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int range = 0;
        for (int i = 1; i <= n; i++) {
            range = Math.max(range - 1, nums[i - 1]);
            if (range == 0 && i < n) {
                return false;
            }
            if (range > n - 1) {
                return true;
            }
        }
        return true;
    }

    /**
     * 跳步游戏
     *
     * @param nums 数组
     * @return 布尔值
     */
    private boolean jumpGame1(int[] nums) {
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0 && i > max + nums[max]) {
                return false;
            }
            max = nums[i] > nums[max] - (i - max) ? i : max;
        }
        return true;
    }

    /**
     * 解题思路：遍历数组，如果遇到0，就向前遍历0之前的元素：如果存在某元素a的值 > 0所在位置与a所在位置的距离(即nums[j] > i-j)，
     * 那么这个数组一定能跨越这个0，继续寻找下一个0；如果遍历完这个0前面的所有元素，
     * 不存在某元素a的值 > 0所在位置与a所在位置的距离（即count==i），则返回false。
     * <p>
     * 没有0的情况下一定可以到达最后
     *
     * @param nums 输入数组
     * @return 布尔值
     */
    public boolean canJump3(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums == null || nums[0] == 0) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int count = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > i - j) {
                        break;
                    } else {
                        count++;
                    }
                    if (count == i) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
