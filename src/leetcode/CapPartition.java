package leetcode;

import org.junit.Test;
import java.util.Arrays;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: CapPartition
 * @Description: TOTO
 * @date 2018/12/10 10:30
 **/

public class CapPartition {
    @Test
    public void fun() {
        int[] nums = {1, 5, 11, 5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {   //sum % 2 == 1
            return false;
        }
        sum /= 2; // sum=sum>>1;
        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }
}