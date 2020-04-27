package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 33 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SearchRotatedSortedArray33 {

    @Test
    public void searchRotatedSortedArrayTest() {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int search = search2(arr, target);
        System.out.println(search);
    }

    /**
     * 找到目标数字的下标
     *
     * @param nums   数组
     * @param target 目标值
     * @return 下标
     */
    public int search(int[] nums, int target) {
        int status = -1;
        for (int a = 0; a < nums.length; a++) {
            if (nums[a] == target) {
                status = a;
                break;
            }
        }
        return status;
    }

    /**
     * 找到目标数字的下标
     *
     * @param nums   数组
     * @param target 目标值
     * @return 下标
     */
    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
