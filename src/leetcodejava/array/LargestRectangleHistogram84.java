package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * This is the solution of No.84 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LargestRectangleHistogram84 {
    @Test
    public void largestRectangleHistogramTest() {
        int[] heights = {1, 2, 3};
        int result = largestRectangleHistogram(heights);
        Assert.assertEquals(result, 4);
    }

    /**
     * 计算数组最大面积
     *
     * @param heights 高度数组
     * @return 面积
     */
    public int largestRectangleHistogram(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        int index = 0;
        // 当下标小于数组的长度,保存所有元素都进入栈中
        while (index <= heights.length) {
            if (stack.isEmpty() || (index < heights.length && heights[index] >= heights[stack.peek()])) {
                stack.push(index);
                index++;
            } else {
                int oldIndex = stack.pop();
                // 当所有元素都出栈时候，宽度就为index
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;
                // 获取面积最大（宽度*高度）
                maxArea = Math.max(maxArea, width * heights[oldIndex]);
            }
        }
        return maxArea;
    }

    /**
     * 计算数组最大面积（brute force）
     *
     * @param heights 高度数组
     * @return 面积
     */
    public int largestRectangleHistogram2(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        int maxArea = 0;
        int n = heights.length;
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < n; i++) {
            int wide = 1, height = heights[i];
            int j = i;
            while (--j >= 0 && heights[j] >= height) {
                wide++;
            }
            j = i;
            while (++j < n && heights[j] >= height) {
                wide++;
            }
            maxArea = Math.max(maxArea, wide * height);
        }
        return maxArea;
    }
}
