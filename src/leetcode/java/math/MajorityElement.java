package leetcode.java.math;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyu
 **/


public class MajorityElement {
    @Test
    public void testMajorityElement() {
        int[] nums = {3, 2, 2, 2, 3};
        int majorElement = majorityElement(nums);
        System.out.println(majorElement);
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
            if (!map.keySet().contains(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
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
        int major = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
