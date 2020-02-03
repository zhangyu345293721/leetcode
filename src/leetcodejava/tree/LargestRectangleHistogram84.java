package leetcodejava.tree;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 计算矩形的面积
 *
 * @author zhangyu
 **/


public class LargestRectangleHistogram84 {
    @Test
    public void testLargestRectangleHistogram() {
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
