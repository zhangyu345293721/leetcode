package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: SubarraySumEqualsK
 * @Description: TOTO
 * @date 2018/12/11 10:22
 **/


public class SubarraySumEqualsK2 {
    @Test
    public void fun() {
        int nums[] = {1, 2, 3};
        int k = 3;
        int key = subarraySum(nums, k);
        System.out.println(key);
    }

    public int subarraySum(int[] nums, int k) {
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
}
