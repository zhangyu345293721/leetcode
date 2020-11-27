package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 按摩师接客问题
 *
 * @author: zhangyu
 */
public class TheMasseuseLCCI16 {

    @Test
    public void theMasseuseLCCTest() {
        int[] arr = {1, 2, 3, 1};
        int massage = massage(arr);
        Assert.assertEquals(massage, 4);
    }

    /**
     * @param nums 数组问题
     * @return 最大数
     */
    public int massage(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int length = nums.length;
        int dp[] = new int[length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
