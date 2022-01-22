package leetcodejava.slidewindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * This is the solution of No.239 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sliding-window-maximum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SlidingWindowMaximum239 {

    @Test
    public void slidingWindowMaximumTest() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int key = 3;
        int[] result = slidingWindowMaximum(nums, key);
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(result, new int[]{3, 3, 5, 5, 6, 7});
    }

    /**
     * @param nums 数组
     * @param k    窗口大小
     * @return list
     */
    private int[] slidingWindowMaximum(int[] nums, int k) {
        if (nums.length < 1) {
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            int temp = i + k;
            int j = i;
            int max = Integer.MIN_VALUE;
            while (j < temp && temp <= nums.length) {
                max = Math.max(max, nums[j]);
                j++;
            }
            res[i] = max;
        }
        return res;
    }

    /**
     * 找最大的数
     *
     * @param nums 数组
     * @param k    窗口大小
     * @return list
     */
    private int[] slidingWindowMaximum2(int[] nums, int k) {
        if (nums.length < 1) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int index = 0;
        for (int i = 0; i < len; i++) {
            // 维护着单调递减队列
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            // 元素已经超过窗口范围
            if (!deque.isEmpty() && i - k >= deque.getFirst()) {
                deque.removeFirst();
            }
            // 增加下标元素
            deque.add(i);
            if (i >= k - 1) {
                res[index++] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
