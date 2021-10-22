package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.861 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/score-after-flipping-matrix
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ScoreAfterFlippingMatrix861 {
    @Test
    public void scoreAfterFlippingMatrixTest() {
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int result = matrixScore2(A);
        Assert.assertEquals(result, 39);
    }

    /**
     * 最大分数
     *
     * @param A 二维数组
     * @return 最大分数
     */
    public int matrixScore1(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        // 将1移动到第一列
        for (int i = 0; i < rows; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        int result = 0;
        int average = rows / 2;
        // 计算每行的和
        for (int j = 0; j < cols; j++) {
            int count = 0;
            for (int i = 0; i < rows; i++) {
                if (A[i][j] == 0) {
                    count++;
                }
            }
            // 转换列
            if (count > average) {
                for (int i = 0; i < rows; i++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
            for (int i = 0; i < rows; i++) {
                if (A[i][j] == 1) {
                    result += Math.pow(2, cols - 1 - j);
                }
            }
        }
        return result;
    }


    /**
     * 最大分数
     *
     * @param A 二维数组
     * @return 最大分数
     */
    public int matrixScore2(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        // 将1移动到第一列
        for (int i = 0; i < rows; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        int result = 0;
        int average = rows / 2;
        // 计算每行的和
        for (int j = 0; j < cols; j++) {
            // 计算1的个数
            int count = 0;
            for (int i = 0; i < rows; i++) {
                if (A[i][j] == 1) {
                    count++;
                }
            }
            if (count > average) {
                result += Math.pow(2, cols - 1 - j) * count;
            } else {
                result += Math.pow(2, cols - 1 - j) * (rows - count);
            }
        }
        return result;
    }
}
