package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No. 1260 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shift-2d-grid
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Shift2DGrid1260 {
    @Test
    public void testShift2DGrid() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        List<List<Integer>> result = shiftGrid(grid, k);
        Assert.assertEquals(result.size(), 3);
    }

    /**
     * 旋转二维数组
     *
     * @param grid 二维数组
     * @param k    次数
     * @return 链表
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while (k > 0) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = grid[0].length - 1; j > 0; j--) {
                    int temp = grid[i][j];
                    grid[i][j] = grid[i][j - 1];
                    grid[i][j - 1] = temp;
                }
                if (i == grid.length - 1) {
                    while (i > 0) {
                        int temp = grid[i][0];
                        grid[i][0] = grid[i - 1][0];
                        grid[i - 1][0] = temp;
                        i--;
                    }
                    break;
                }
            }
            k--;
        }
        return new ArrayList(Arrays.asList(grid));
    }
}
