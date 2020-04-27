package leetcodejava.top100likedquestions;

import org.junit.Test;

/**
 * This is the solution of No.200 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class NumberIslands200 {
    @Test
    public void testNumberIslands() {
        char[][] chs = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '0', '0'},
                {'1', '0', '1'}
        };
        int num = numIslands(chs);
        System.out.println(num);
    }

    /**
     * 计算岛屿的个数
     *
     * @param grid 二维数组
     * @return 岛屿个数
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    helper(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 递归每个元素
     *
     * @param grid    二维数组
     * @param visited 是否访问过
     * @param x       x坐标
     * @param y       y坐标
     */
    private void helper(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return;
        }
        if (y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] != '1' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        helper(grid, visited, x - 1, y);
        helper(grid, visited, x + 1, y);
        helper(grid, visited, x, y - 1);
        helper(grid, visited, x, y + 1);
    }
}
