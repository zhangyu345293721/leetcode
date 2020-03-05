package leetcodejava.top100likedquestions;

import org.junit.Test;

/**
 * 计算岛屿的个数
 *
 * @author: zhangyu   '
 * 11110
 * 11010
 * 11000
 * 00000
 */
public class NumberIslands200 {
    @Test
    public void testNumberIslands() {
        char[][] chs = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '0'}
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
