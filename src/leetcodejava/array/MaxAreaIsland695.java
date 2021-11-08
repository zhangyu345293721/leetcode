package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

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
        int[][] grid = {{1, 1, 1}, {1, 0, 1}};
        int result = maxAreaOfIsland3(grid);
        System.out.println(result);
        Assert.assertEquals(result, 5);
    }

    /**
     * 岛屿的最大面积
     *
     * @param grid 二维数组
     * @return 岛屿面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int count = searchHelper(grid, i, j);
                    result = Math.max(count, result);
                }
            }
        }
        return result;
    }

    /**
     * 深度优先搜索帮助类
     *
     * @param grid 二维数组
     * @param i    位置i
     * @param j    位置j
     * @return count
     */
    private int searchHelper(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += searchHelper(grid, i + 1, j);
        count += searchHelper(grid, i - 1, j);
        count += searchHelper(grid, i, j - 1);
        count += searchHelper(grid, i, j + 1);
        return count;
    }

    private int count;

    /**
     * 岛屿的最大面积
     *
     * @param grid 二维数组
     * @return 岛屿面积
     */
    public int maxAreaOfIsland2(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    searchHelper2(grid, i, j, visited);
                    result = Math.max(count, result);
                }
            }
        }
        return result;
    }

    /**
     * 递归帮助类
     *
     * @param grid 二维数组
     * @param i    位置i
     * @param j    位置j
     */
    private void searchHelper2(int[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        count++;
        searchHelper2(grid, i + 1, j, visited);
        searchHelper2(grid, i - 1, j, visited);
        searchHelper2(grid, i, j - 1, visited);
        searchHelper2(grid, i, j + 1, visited);
    }

    /**
     * 岛屿的最大面积
     *
     * @param grid 二维数组
     * @return 岛屿面积
     */
    public int maxAreaOfIsland3(int[][] grid) {
        if (grid == null || grid[0].length < 1) {
            return 0;
        }
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int cnt = 0;
                if (grid[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    while (!queue.isEmpty()) {
                        int[] p = queue.poll();
                        cnt++;
                        for (int[] d : directions) {
                            int x = p[0] + d[0], y = p[1] + d[1];
                            if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                                queue.offer(new int[]{x, y});
                                grid[x][y] = 0;
                            }
                        }
                        result = Math.max(result, cnt);
                    }
                }
            }
        }
        return result;
    }
}