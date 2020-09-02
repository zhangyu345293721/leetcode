package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 1248 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CountNumberNiceSubarrays1248 {

    @Test
    public void countNumberNiceSubarraysTest() {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 1;
        int count = numberOfSubarrays(nums, k);
        System.out.println(count);
    }

    /**
     * 完美数组数量
     *
     * @param nums 数组
     * @param k    k个基数
     * @return 数量
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int[] subArray = arraySub(nums, i, j);
                count += statisticCount(subArray, k);
            }
        }
        return count;
    }

    /**
     * 最美数组
     *
     * @param subArray 子数组
     * @param count    数量
     * @return 最美数组
     */
    private int statisticCount(int[] subArray, int count) {
        int number = 0;
        for (int num : subArray) {
            if (num % 2 == 1) {
                number++;
            }
        }
        return count == number ? 1 : 0;
    }

    /**
     * 截取数组
     *
     * @param data  数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 数组
     */
    public int[] arraySub(int[] data, int start, int end) {
        int[] arr = new int[end - start + 1];
        int j = 0;
        for (int i = start; i <= end; i++) {
            arr[j] = data[i];
            j++;
        }
        return arr;
    }
}
