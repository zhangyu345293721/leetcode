package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 1252 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
 * <p>
 * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * <p>
 * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
 * <p>
 * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, m = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 * 示例 2：
 * <p>
 * 输入：n = 2, m = 2, indices = [[1,1],[0,0]]
 * 输出：0
 * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 * 1 <= m <= 50
 * 1 <= indices.length <= 100
 * 0 <= indices[i][0] < n
 * 0 <= indices[i][1] < m
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CellsOddValues1252 {

    @Test
    public void testCellsOddValues() {
        int n = 2;
        int m = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        int num = oddCells(n, m, indices);
        Assert.assertEquals(num, 6);
    }

    /**
     * 奇数个数
     *
     * @param n       n行
     * @param m       m列
     * @param indices 引导数组
     * @return 奇数个数
     */
    public int oddCells(int n, int m, int[][] indices) {
        int[][] cells = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int[] index = indices[i];
            int row = index[0];
            int col = index[1];
            for (int c = 0; c < cells[row].length; c++) {
                cells[row][c] += 1;
            }
            for (int c = 0; c < cells.length; c++) {
                cells[c][col] += 1;
            }
        }
        int number = getOddNumbers(cells);
        return number;

    }

    /**
     * 获取奇数的个数
     *
     * @param cells 二维数组
     * @return 奇数
     */
    private int getOddNumbers(int[][] cells) {
        int count = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
