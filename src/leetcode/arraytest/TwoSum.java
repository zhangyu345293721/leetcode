package leetcode.arraytest;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: TwoSum
 * @Description: 计算两个数的和
 * @date 2019/1/5 11:03
 **/


public class TwoSum {
    @Test
    public void fun() {
        int[] nums = {1, 2,2,3, 3, 7};
        int target = 5;
        int[] arr = getSumIndex2(nums, target);
        System.out.println(Arrays.toString(arr));
    }

    // brute force 时间复杂度：O(n^2) 空间复杂度:O(1)
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

    // 一种比较优的解决方式 利用hashmap
    // 时间复杂度:O(n) 空间复杂度:(1)
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
