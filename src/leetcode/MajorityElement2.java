package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: MajorityElement2
 * @Description: TOTO
 * @date 2018/12/2 15:05
 **/


public class MajorityElement2 {
    @Test
    public void fun() {
        int[] nums = {1, 2, 3, 2, 2, 2, 2};
        int key = majorityElement(nums);
        System.out.println(key);
    }
    // 找出一个数的个数大于数组中一半的长度
    private int majorityElement(int[] nums) {
        //if (nums == null || nums.length == 0) return 0;
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
