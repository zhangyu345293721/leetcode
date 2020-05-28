package leetcodejava.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.239 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sliding-window-maximum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SlidingWindowMaximum239 {

    @Test
    public void testSlidingWindowMaximum() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int key = 3;
        List<Integer> arr = slidingWindowMaximum(nums, key);
        System.out.println(arr);
    }

    /**
     * 最大活动窗口
     *
     * @param nums 数组
     * @param key  关键字
     * @return list
     */
    private List<Integer> slidingWindowMaximum(int[] nums, int key) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - key + 1; i++) {
            int temp = i + key;
            int j = i;
            int max = Integer.MIN_VALUE;
            while (j < temp && temp <= nums.length) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                j++;
            }
            list.add(max);
        }
        return list;
    }


    /**
     * @param nums 数组
     * @param key  关键字
     * @return list
     */
    private int[] slidingWindowMaximum2(int[] nums, int key) {
        if (nums.length < 1) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - key + 1; i++) {
            int temp = i + key;
            int j = i;
            int max = Integer.MIN_VALUE;
            while (j < temp && temp <= nums.length) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                j++;
            }
            list.add(max);
        }
        // 把链表变成数组
        int[] arr = new int[list.size()];
        int index = 0;
        for (int num : list) {
            arr[index] = num;
            index++;
        }
        return arr;
    }
}
