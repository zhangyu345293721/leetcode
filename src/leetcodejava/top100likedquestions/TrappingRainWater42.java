package leetcodejava.top100likedquestions;

import org.junit.Test;

/**
 * This is the solution of No.42 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TrappingRainWater42 {
    @Test
    public void trappingRainWaterTest() {
        int height[] = {1 , 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int maxWater = trappingRainWater(height);
        System.out.println(maxWater);
    }

    /**
     * 装多少水
     *
     * @param height 数组
     * @return 多少水
     */
    private int trappingRainWater(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int result = 0;
        int size = height.length;
        for (int i = 0; i < size ; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            result += Math.min(maxLeft, maxRight) - height[i];
        }
        return result;
    }

    /**
     * 装多少水
     *
     * @param height 数组
     * @return 多少水
     */
    private int trappingRainWater2(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                result += (leftMax - height[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += (rightMax - height[right]);
                right--;
            }
        }
        return result;
    }
}
