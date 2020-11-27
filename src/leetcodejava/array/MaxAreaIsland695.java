package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 695 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/max-area-of-island
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * <p>
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 * <p>
 * 示例 2:
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaxAreaIsland695 {

    @Test
    public void maxAreaIslandTest() {
        int[][] grid = {{0, 1, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 1, 0, 0, 0, 0}};
        int count = maxAreaOfIsland2(grid);
        System.out.println(count);
    }

    /**
     * 岛屿的最大面积
     *
     * @param grid 二维数组
     * @return 岛屿面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0, row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int count = helper(grid, i, j);
                    if (maxIsland < count) {
                        maxIsland = count;
                    }
                }
            }
        }
        return maxIsland;
    }

    /**
     * 递归帮助类
     *
     * @param grid 二维数组
     * @param i    位置i
     * @param j    位置j
     * @return count
     */
    private int helper(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += helper(grid, i + 1, j);
        count += helper(grid, i - 1, j);
        count += helper(grid, i, j - 1);
        count += helper(grid, i, j + 1);
        return count;
    }

    /**
     * 递归帮助类
     *
     * @param grid 二维数组
     * @param i    位置i
     * @param j    位置j
     * @return count
     */
    private int helper2(int[][] grid, int i, int j, int[] count, boolean[][] visited) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || visited[i][j] || grid[i][j] == 0) {
            return count[0];
        }
        visited[i][j] = true;
        count[0]++;
        helper2(grid, i + 1, j, count, visited);
        helper2(grid, i - 1, j, count, visited);
        helper2(grid, i, j - 1, count, visited);
        helper2(grid, i, j + 1, count, visited);
        return count[0];
    }

    /**
     * 岛屿的最大面积
     *
     * @param grid 二维数组
     * @return 岛屿面积
     */
    public int maxAreaOfIsland2(int[][] grid) {
        int maxIsland = 0, row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int count = helper2(grid, i, j, new int[1], visited);
                    if (maxIsland < count) {
                        maxIsland = count;
                    }
                }
            }
        }
        return maxIsland;
    }
}
