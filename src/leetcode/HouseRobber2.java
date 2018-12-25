package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/*
 * @author zhangyu
 * @version V1.0
 * @ClassName: HouseRobber1
 * @Description: 这是一个动态规划的考题，这种方式只是做出来其中的一种，里面还有别的做法
 * @date 2018/12/4 17:11
 */

public class HouseRobber2 {
    @Test
    public void fun() {
        //int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {1, 1, 1};
        int totalMoney = houseRobber(nums);
        System.out.println(totalMoney);
    }

    // 利用动态规划进行求解问题
    private int houseRobber(int[] nums) {
        // 当数组长度为0,直接返回0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义一个数组的大小
        int len = nums.length;
        int i = 2;
        if (len == 1) {
            return nums[0];
        }
        int[] f = new int[len];
        f[0] = nums[0];
        f[1] = Math.max(f[0], nums[1]);
        for (; i < len; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
        return f[i - 1];

    }

}
