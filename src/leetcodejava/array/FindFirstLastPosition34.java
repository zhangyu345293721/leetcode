package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.34 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindFirstLastPosition34 {
    @Test
    public void findFirstLastPositionTest() {
        int nums[] = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(Arrays.toString(result));
        Assert.assertEquals(result[0], 4);
    }


    /**
     * 找出相同的里面最小,最小那个
     *
     * @param nums   数组
     * @param target 目标值
     * @return int
     */
    public int[] searchRange(int[] nums, int target) {
        int start = findFirstPosition(nums, target);
        int end = findLastPosition(nums, target);
        return new int[]{start, end};
    }

    /**
     * 找出相同的里面最小那个
     *
     * @param nums   数组
     * @param target 目标值
     * @return int
     */
    private int findFirstPosition(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            }
        }
        return index;
    }

    /**
     * 找出相同中最后面那个
     *
     * @param nums   数组
     * @param target 目标值
     * @return int
     */
    private int findLastPosition(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            }
        }
        return index;
    }
}
