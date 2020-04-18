package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 11 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/container-with-most-water
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ContainerMostWater11 {

    @Test
    public void containerMostWaterTest() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea2(height);
        System.out.println(maxArea);
    }

    /**
     * 计算最大面积
     * @param height 高度数组
     * @return 最大面积
     */
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i));
            }
        }
        return maxArea;
    }

    /**
     * 计算最大面积
     * @param height 高度数组
     * @return 最大面积
     */
    public int maxArea2(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        int i = 0,j = height.length - 1;
        while (i<j){
            if(height[i]<height[j]){
                maxArea=Math.max(maxArea,height[i]*(j-i));
                i++;
            }else{
                maxArea=Math.max(maxArea,height[j]*(j-i));
                j--;
            }
        }
        return maxArea;
    }
}
