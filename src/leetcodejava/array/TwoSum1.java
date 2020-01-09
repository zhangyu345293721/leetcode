package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 计算两个数的和
 *
 * @author zhangyu
 **/


public class TwoSum1 {
    @Test
    public void testTwoSum() {
        int[] nums = {1, 2, 2, 3, 3, 7};
        int target = 5;
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
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
