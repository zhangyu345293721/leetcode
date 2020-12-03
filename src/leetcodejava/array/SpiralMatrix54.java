package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.54 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SpiralMatrix54 {

    @Test
    public void spiralMatrixTest() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = spiralOrder(matrix);
        Assert.assertEquals(result.get(0).intValue(), 1);
    }

    /**
     * 螺旋顺序输出数组
     *
     * @param matrix 二维数据
     * @return 一维数组
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> result = new ArrayList();
        while (true) {
            // 从左向右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (left > --right) {
                break;
            }
            // 从右向左
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            if (top > --bottom) {
                break;
            }
            // 从下到上
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return result;
    }
}
