package leetcode.java.array;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class JumpGame55 {
    @Test
    public void testJumpGame() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean flag = canJump2(nums);
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
            if (range == 0 && i < n)
                return false;
            if (range > n - 1)
                return true;
        }
        return true;
    }

    /**
     * 跳步游戏
     *
     * @param nums 数组
     * @return 布尔值
     */
    private boolean jumpGame(int[] nums) {
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0 && i > max + nums[max]) {
                return false;
            }
            //max = nums[i] > nums[max] - (i - max) ? i : max;
            if (nums[i] > nums[max] - (i - max)) {
                max = i;
            }
        }
        return true;
    }
}
