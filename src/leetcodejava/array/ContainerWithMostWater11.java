package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No.11 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/container-with-most-water
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ContainerWithMostWater11 {

    @Test
    public void coinChangeTest() {
        int height[] = {1, 2, 5};
        int area = maxArea(height);
        System.out.println(area);
    }

    /**
     * 暴力算法（brute force）
     *
     * @param height 长度数组
     * @return 面积
     */
    private  int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int high = Math.min(height[i], height[j]);
                int wide = j - i;
                int area = high * wide;
                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    /**
     * 快速排序的基本思想
     *
     * @param height 长度数组
     * @return 面积
     */
    private  int maxArea2(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
