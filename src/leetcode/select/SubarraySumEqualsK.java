package leetcode.select;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author zhangyu
 **/


public class SubarraySumEqualsK {
    @Test
    public void testSubarraySumEqualsK() {
        int nums[] = {1, 2, 3};
        int k = 3;
        int key = subarraySum(nums, k);
        System.out.println(key);
    }

    /**
     * 求和
     *
     * @param nums 数组
     * @param k    k个数
     * @return 数字和
     */
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                    sum = 0;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 求和
     *
     * @param nums 数组
     * @param k    k个数
     * @return 数字和
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 求和
     *
     * @param nums 数组
     * @param k    k个数
     * @return 数字和
     */
    public int subarraySum3(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
        }
        return count;
    }

    /**
     * 求和
     *
     * @param nums 数组
     * @param k    k个数
     * @return 数字和
     */
    public int subarraySum4(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
