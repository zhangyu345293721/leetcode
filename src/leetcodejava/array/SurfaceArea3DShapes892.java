package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 892 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 请你返回最终形体的表面积。
 * 示例 1：
 * <p>
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 * <p>
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SurfaceArea3DShapes892 {

    @Test
    public void surfaceArea3DShapesTest() {
        int[][] arr = {{1, 2}, {3, 4}};
        int i = surfaceArea(arr);
        Assert.assertEquals(i, 34);
    }

    /**
     * 1.计算所有的表面积
     * 2.将去掉重合部分的表面积(重复方向有x方向和y方向)
     *
     * @param grid 二维数组
     * @return 总的表面积
     */
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int n = grid.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    area += grid[i][j] * 4 + 2;
                    if (i > 0) {
                        area -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                    }
                    if (j > 0) {
                        area -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                    }
                }
            }
        }
        return area;
    }
}
