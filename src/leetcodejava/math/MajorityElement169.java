package leetcodejava.math;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyu
 **/


public class MajorityElement169 {
    @Test
    public void testMajorityElement() {
        int[] nums = {3, 2, 2, 2, 3};
        int majorElement = majorityElement2(nums);
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
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
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
