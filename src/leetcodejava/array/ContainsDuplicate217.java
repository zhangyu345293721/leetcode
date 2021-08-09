package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This is the solution of No. 217 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/contains-duplicate
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ContainsDuplicate217 {

    @Test
    public void containsDuplicateTest() {
        int[] nums = {1, 2, 3, 4};
        boolean result = containsDuplicate(nums);
        Assert.assertEquals(result, true);
    }

    /**
     * 数组中是否包含重复的数
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数组中是否包含重复的数
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
