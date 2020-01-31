package leetcodejava.array;

import org.junit.Test;

/**
 * 色彩变换
 *
 * @author: zhangyu
 */
public class FloodFill733 {

    @Test
    public void testFloodFill() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] oldColor = floodFill(image, sr, sc, newColor);
        System.out.println(oldColor);
    }

    /**
     * @param image    图片二维数组
     * @param sr       sr输入
     * @param sc       sc输入
     * @param newColor 新颜色
     * @return 二维数组
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return floodFillMethod(image, sr, sc, image[sr][sc], newColor);
    }

    /**
     * 图片变换
     *
     * @param image    二维数组
     * @param sr       sr变换
     * @param sc       sc变换
     * @param oldColor 老颜色
     * @param newColor 新颜色
     * @return 二维数组
     */
    public int[][] floodFillMethod(int[][] image, int sr, int sc, int oldColor, int newColor) {
        int rowLength = image.length;
        int colmnLength = image[0].length;
        if (sr < 0 || sr >= rowLength || sc < 0 || sc >= colmnLength || image[sr][sc] != oldColor || image[sr][sc] == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        floodFillMethod(image, sr + 1, sc, oldColor, newColor);
        floodFillMethod(image, sr, sc + 1, oldColor, newColor);
        floodFillMethod(image, sr - 1, sc, oldColor, newColor);
        floodFillMethod(image, sr, sc - 1, oldColor, newColor);
        return image;
    }
}
