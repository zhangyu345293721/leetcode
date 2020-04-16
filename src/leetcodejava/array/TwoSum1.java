package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 1 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/two-sum
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TwoSum1 {
    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] arr = getSumIndex2(nums, target);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * brute force 时间复杂度：O(n^2) 空间复杂度:O(1)
     *
     * @param nums   数组
     * @param target 目标
     * @return 返回结果
     */
    private int[] getSumIndex1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 一种比较优的解决方式 利用hashmap,时间复杂度:O(n) 空间复杂度:(1)
     *
     * @param nums   数组
     * @param target 目标
     * @return 数组
     */
    private int[] getSumIndex2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
