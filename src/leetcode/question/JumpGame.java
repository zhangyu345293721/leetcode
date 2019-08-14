package leetcode.question;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: JumpGame
 * @Description: TOTO
 * @date 2018/12/13 16:26
 **/


public class JumpGame {
    @Test
    public void fun() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean flag = canJump2(nums);
        System.out.println(flag);
    }

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
