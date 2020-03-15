package leetcodejava.array;

import org.junit.Test;

/**
 * 最大岛屿面积
 *
 * @author: zhangyu
 */
public class MaxAreaIsland695 {

    @Test
    public void testMaxAreaIsland() {
        int[][] grid = {{0, 1, 1, 1, 1, 0, 0, 0},{0, 1, 1, 1, 0, 0, 0, 0}};
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
