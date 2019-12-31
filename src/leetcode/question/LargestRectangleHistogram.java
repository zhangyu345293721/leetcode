package leetcode.question;

import org.junit.Test;

import java.util.Stack;

/**
 * 计算矩形的面积
 *
 * @author zhangyu
 **/


public class LargestRectangleHistogram {
    @Test
    public void fun() {
        //int[] arrs = {2, 1, 5, 6, 2, 3};
        int[] arrs = {1, 2, 3};
        int maxArea = largestRectangleHistogram(arrs);
        System.out.println(maxArea);
    }

    public int largestRectangleHistogram(int[] heights) {
        // 如果数组为空直接返回0
        if (heights == null || heights.length == 0) {
            return 0;
        }
        // 定义一个stack记录位置
        Stack<Integer> stack = new Stack<>();
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
