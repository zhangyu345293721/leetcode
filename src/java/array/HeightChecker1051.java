package java.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 高度检查
 *
 * @author: zhangyu
 */
public class HeightChecker1051 {

    @Test
    public void testHeightChecker() {
        int[] nums = {2, 1, 2, 1, 1, 2, 2, 1};
        int num = heightChecker(nums);
        System.out.println(num);
    }

    /**
     * 高度检查
     *
     * @param heights 高度数组
     * @return 检查错误
     */
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights,heights.length);
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
