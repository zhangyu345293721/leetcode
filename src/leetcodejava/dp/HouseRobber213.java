package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.213 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/house-robber-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class HouseRobber213 {

    @Test
    public void houseRobberTest() {
        int[] nums = {2, 3, 2};
        int result = houseRobber(nums);
        System.out.println(result);
        Assert.assertEquals(result, 4);
    }

    /**
     * 抢劫最大值
     *
     * @param nums 圆形数组
     * @return int
     */
    public int houseRobber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 分两种情况，选择第一家和不选择第一家的情况
        // 没选第一个家偷窃
        int result1 = houseRobberHelper(nums, 1, n - 1);
        // 选第一家偷窃
        int result2 = houseRobberHelper(nums, 2, n - 2) + nums[0];
        // 最后返回两种方式中最大值
        return Math.max(result1, result2);
    }

    /**
     * 求总共钱数
     *
     * @param nums 数组
     * @return 钱数
     */
    private int houseRobberHelper(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }
        int n = nums.length;
        if (r == l) {
            return nums[l];
        }
        // 定义数组
        int dp[] = new int[n];
        // 初始化数组
        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);
        // 动态转移方程
        for (int i = l + 2; i <= r; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[r];
    }
}
