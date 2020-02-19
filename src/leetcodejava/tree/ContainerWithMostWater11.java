package leetcodejava.tree;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class ContainerWithMostWater11 {

    @Test
    public void testCoinChange() {
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
