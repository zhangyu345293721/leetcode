package leetcode;

import org.junit.Test;
import java.util.Arrays;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: CapPartition
 * @Description: 动态规划，计算该数组是不是可以分成平等的两部分
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
        // 获取数组的总和
        for (int num : nums) {
            sum += num;
        }
        // 如果它的值为奇数直接返回false
        if ((sum & 1) == 1) {   //sum % 2 == 1
            return false;
        }
        // 把这个数除以2得到它的一半
        sum /= 2; // sum=sum>>1;
       // int n = nums.length;
        // 定义一个总数一半的sum
        boolean[] dp = new boolean[sum + 1];
        // 数组中填空false
        Arrays.fill(dp, false);
        dp[0] = true;
        // 动态规划找出，是否满足这个数的和
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }
}