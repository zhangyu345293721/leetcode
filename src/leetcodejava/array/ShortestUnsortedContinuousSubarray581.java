package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * This is the solution of No.581 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * <p>
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * <p>
 * 来源：力扣（lefteetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ShortestUnsortedContinuousSubarray581 {
    @Test
    public void shortestUnsortedContinuousSubarrayTest() {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int num = findUnsortedSubarray3(nums);
        Assert.assertEquals(num, 5);
    }

    /**
     * 查找最短没有排序的数组
     *
     * @param nums 数组
     * @return 没排序数组长度
     */
    private int findUnsortedSubarray(int[] nums) {
        int[] newNums = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(newNums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] == newNums[i]) {
                i++;
            } else if (nums[j] == newNums[j]) {
                j--;
            } else if (i == j) {
                return 0;
            } else {
                return j - i + 1;
            }
        }
        return 0;
    }

    /**
     * 查找最短没有排序的数组
     *
     * @param nums 数组
     * @return 没排序数组长度
     */
    public int findUnsortedSubarray2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int right = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                right = i;
            }
            max = Math.max(max, nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (min < nums[i]) {
                left = i;
            }
            min = Math.min(min, nums[i]);
        }
        return right == left ? 0 : right - left + 1;
    }

    /**
     * 查找最短没有排序的数组
     *
     * @param nums 数组
     * @return 没排序数组长度
     */
    public int findUnsortedSubarray3(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int left = Integer.MAX_VALUE;
        int right = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(stack.pop(), left);
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(stack.pop(), right);
            }
            stack.push(i);
        }
        return right > left ? right - left + 1 : 0;
    }
}
