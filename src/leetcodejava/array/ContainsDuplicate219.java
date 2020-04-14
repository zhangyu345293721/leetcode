package leetcodejava.array;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 219 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/contains-duplicate-ii
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ContainsDuplicate219 {

    @Test
    public void testContainsDuplicate() {
        int[] arr = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean flag = containsNearbyDuplicate2(arr, k);
        System.out.println(flag);
    }

    /**
     * 判断是否重复
     *
     * @param nums 数组
     * @param k    数
     * @return 布尔值
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否重复
     *
     * @param nums 数组
     * @param k    数
     * @return 布尔值
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if (Math.abs(index - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
