package leetcode.tree;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 计算矩形的面积
 *
 * @author zhangyu
 **/


public class LargestRectangleHistogram {
    @Test
    public void fun() {
        int[] arrs = {1, 2, 3};
        int maxArea = largestRectangleHistogram(arrs);
        System.out.println(maxArea);
    }

    public int largestRectangleHistogram(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        // Stack<Integer> stack = new Stack<>();
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
