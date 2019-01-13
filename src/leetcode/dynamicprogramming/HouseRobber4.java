package leetcode.dynamicprogramming;

import org.junit.Test;

/*
 * @author zhangyu
 * @version V1.0
 * @ClassName: HouseRobber1
 * @Description: 这是一个动态规划的考题，这种方式只是做出来其中的一种，里面还有别的做法
 * @date 2018/11/4 17:11
 */

public class HouseRobber4 {
    @Test
    public void fun() {
        //int[] nums = {1, 2, 3, 1};
         int[] nums = {2, 7, 9, 3, 1};
        //int[] nums = {1, 1, 1};
        int totalMoney = houseRobber(nums);
        System.out.println(totalMoney);
    }

    private int houseRobber(int[] nums) {
        int preMax=0, max=0;
        for(int num : nums) {
            int temp = Math.max(preMax+num, max);
            preMax = max;
            max = temp;
        }
        return max;
    }
}
