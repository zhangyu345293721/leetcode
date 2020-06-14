package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 1300 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，
 * 数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * <p>
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * <p>
 * 请注意，答案不一定是 arr 中的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 * <p>
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SumMutatedArrayClosestTarget1300 {

    @Test
    public void sumMutatedArrayClosestTargetTest() {
        int[] arr = {48772, 52931, 14253, 32289, 75263};
        int target = 40876;
        int bestValue = findBestValue(arr, target);
        System.out.println(bestValue);

    }

    /**
     * @param arr    数组
     * @param target 目标值
     * @return 返回值
     */
    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        int avg = target / n;
        // 记录当前一轮的差值
        int current = Integer.MAX_VALUE;
        int max = 0;
        // 找出数组中最大值
        for (int num : arr) {
            max = Math.max(num, max);
        }
        if (max < avg) {
            return max;
        }
        // 从平均值开始遍历
        for (int i = avg; ; ++i) {
            // 记录每轮的总和
            int sum = 0;
            for (int value : arr) {
                if (value > i) {
                    sum += i;
                } else {
                    sum += value;
                }
            }
            if (Math.abs(sum - target) >= current) {
                return i - 1;
            }
            current = Math.abs(sum - target);
        }
    }
}
