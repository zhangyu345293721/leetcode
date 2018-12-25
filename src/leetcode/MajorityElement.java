package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: MajorityElement
 * @Description: TOTO
 * @date 2018/12/2 14:27
 **/


public class MajorityElement {
    @Test
    public void fun() {
        int[] nums = {3, 2,2,2,3};
        int majorElement = majorityElement(nums);
        System.out.println(majorElement);
    }

    // 利用map存储每个int数字出现的次数
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
}
