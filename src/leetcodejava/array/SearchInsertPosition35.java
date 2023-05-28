package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 35 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/search-insert-position
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SearchInsertPosition35 {

    @Test
    public void searchInsertPositionTest() {
        int[] arr = {1, 3, 5, 6};
        int target = 5;
        int result = searchIndex(arr, target);
        Assert.assertEquals(result, 2);
    }

    /**
     * 插入目标数的位置
     *
     * @param nums   目标数组
     * @param target 目标数
     * @return 位置
     */
    private int searchIndex(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (nums[length - 1] < target) {
            return length;
        }
        if (nums[0] >= target) {
            return 0;
        }
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] < target && nums[i + 1] >= target) {
                return i + 1;
            }
        }
        return -1;
    }


    /**
     * 插入目标数的位置
     *
     * @param nums   目标数组
     * @param target 目标数
     * @return 位置
     */
    public int searchIndex2(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int middle = i + (j - i) / 2;
            if (nums[middle] > target) {
                j = middle - 1;
            } else if (nums[middle] < target) {
                if (nums[middle + 1] >= target) {
                    return middle + 1;
                } else {
                    i = middle + 1;
                }
            } else {
                return middle;
            }
        }
        if (nums[j] < target) {
            return j + 1;
        }
        return -1;
    }

    /**
     * 插入目标数的位置
     *
     * @param nums   目标数组
     * @param target 目标数
     * @return 位置
     */
    public int searchInsert3(int[] nums, int target) {
        if(nums == null || nums.length < 1) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    
    /**
     * 插入目标数的位置
     *
     * @param nums   目标数组
     * @param target 目标数
     * @return 位置
     */
    public int searchInsert4(int[] nums, int target) {
        if ( nums == null || nums.length < 1) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        // 第一个数大于target
        if( nums[0] > target) {
            return 0;
        }
        // 最大一个数小于target
        if( nums[j] < target) {
            return nums.length;
        }
        // 二分查找
        while( i <= j) {
            int mid = (j - i) / 2 + i;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                if(mid > 0 && nums[mid - 1] < target) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
}
