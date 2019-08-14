package leetcode.question;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: ContainerWithMostWater
 * @Description: TOTO
 * @date 2018/11/19 20:48
 **/


public class ContainerWithMostWater {
   /* @Test
    public void fun() {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(nums);
        System.out.println(maxArea);
    }*/

    // 暴力算法（brute force）
    private static int maxArea(int[] height) {
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

    // 快速排序的基本思想
    private static int maxArea2(int[] height) {
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
