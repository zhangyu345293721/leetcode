package leetcodejava.array;

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
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
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
        int maxArea = largestRectangleHistogram(heights);
        System.out.println(maxArea);
    }

    /**
     * 计算数组最大面试
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
        // 当下标小于数组的长度
        while (index <= heights.length) {
            if (stack.isEmpty() || (index < heights.length && heights[index] >= heights[stack.peek()])) {
                stack.push(index);
                index++;
            } else {
                int oldIndex = stack.pop();
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;
                // 获取面积最大（宽度*高度）
                maxArea = Math.max(maxArea, width * heights[oldIndex]);
            }
        }
        return maxArea;
    }
}
