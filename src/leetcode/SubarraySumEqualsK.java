package leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author zhangyu
 **/


public class  SubarraySumEqualsK {
    @Test
    public void fun() {
        int nums[] = {1, 2, 3};
        int k = 3;
        int key = subarraySum(nums, k);
        System.out.println(key);
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {   // 终于找到了哪里错误
                    count++;
                    sum = 0;      // 进行初始化
                    break;
                }

            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {   // 终于找到了哪里错误
                    count++;
                }
            }
        }
        return count;
    }

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
