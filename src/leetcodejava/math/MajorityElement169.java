package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 169 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/majority-element/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of size n, find the majority element. The majority element is the element that
 * appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MajorityElement169 {
    @Test
    public void majorityElementTest() {
        int[] nums = {3, 2, 2, 2, 3};
        int result = majorityElement3(nums);
        System.out.println(result);
        Assert.assertEquals(result, 2);
    }

    /**
     * 计算每个字符出现次数
     *
     * @param nums 数组
     * @return map
     */
    private int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int majorSize = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majorSize) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 找出一个数的个数大于数组中一半的长度
     *
     * @param nums 数组
     * @return int类型
     */
    private int majorityElement2(int[] nums) {
        int major = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count++;
            } else if (major == num) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    /**
     * 找出一个数的个数大于数组中一半的长度
     *
     * @param nums 数组
     * @return int类型
     */
    private int majorityElement3(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        return getMajority(nums, 0, nums.length - 1);
    }

    /**
     * 获取最大多元素
     *
     * @param nums  元素数组
     * @param left  左边位置
     * @param right 右边位置
     * @return 最多元素
     */
    private int getMajority(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftMajority = getMajority(nums, left, mid);
        int rightMajority = getMajority(nums, mid + 1, right);
        if (leftMajority == rightMajority) {
            return leftMajority;
        }
        int leftCount = 0;
        int rightCount = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == leftMajority) {
                leftCount++;
            }
            if (nums[i] == rightMajority) {
                rightCount++;
            }
        }
        return leftCount > rightCount ? leftMajority : rightMajority;
    }
}
