package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 867 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/transpose-matrix
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * <p>
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * <p>
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TransposeMatrix867 {

    @Test
    public void transposeMatrixTest() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] A = transpose(a);
        System.out.println(Arrays.toString(A));
        Assert.assertEquals(A.length, 2);
    }

    /**
     * 转置一个二维数组
     *
     * @param A 二维数组
     * @return 转置后数组
     */
    public int[][] transpose(int[][] A) {
        int r = A[0].length;
        int c = A.length;
        int[][] result = new int[r][c];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
