package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * set是否分为两部分
 *
 * @author: zhangyu
 */
public class PartitionEqualSubsetSum416 {
    @Test
    public void testPartitionEqualSubsetSum() {
        int[] nums = {1, 5, 11, 5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    /**
     * 集合是否能分成相等两部分
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean canPartition(int[] nums) {
        int sum= Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {   //sum % 2 == 1
            return false;
        }
        sum /= 2; // sum=sum>>1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }
}