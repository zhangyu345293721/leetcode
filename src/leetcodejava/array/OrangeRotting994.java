package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No.994 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/rotting-oranges
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * <p>
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class OrangeRotting994 {

    @Test
    public void orangeRottingTest() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int result = orangesRotting2(grid);
        System.out.println(result);
        Assert.assertEquals(result, 4);

    }

    /**
     * 橘子腐烂
     *
     * @param grid 二维数组
     * @return 腐烂天数
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid[0].length < 1) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2 && !visited[i][j]) {
                    searchHelper(grid, i, j, visited);
                    count++;
                }
            }
        }
        // 如果还有没有腐烂的，返回-1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    /**
     * 深度优先遍历
     *
     * @param grid    二维数组
     * @param i       坐标i
     * @param j       坐标j
     * @param visited 数组是否访问
     */
    private void searchHelper(int[][] grid, int i, int j, boolean[][] visited) {
        if (grid == null) {
            return;
        }
        if (i >= grid.length || i < 0) {
            return;
        }
        if (j >= grid[0].length || j < 0) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
        }
        visited[i][j] = true;
        searchHelper(grid, i + 1, j, visited);
        searchHelper(grid, i - 1, j, visited);
        searchHelper(grid, i, j + 1, visited);
        searchHelper(grid, i, j - 1, visited);
    }

    /**
     * 橘子腐烂(广度优先遍历)
     *
     * @param grid 二维数组
     * @return 腐烂天数
     */
    public int orangesRotting2(int[][] grid) {
        if (grid == null || grid[0].length < 1) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int round = 0;
        boolean[][] visited = new boolean[row][col];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 新鲜橘子个数
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2 && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1 && !visited[i][j]) {
                    freshOranges++;
                }
            }
        }
        while (freshOranges > 0 && !queue.isEmpty()) {
            int size = queue.size();
            round++;
            for (int k = 0; k < size; k++) {
                int[] point = queue.poll();
                int pointX = point[0];
                int pointY = point[1];
                for (int[] d : directions) {
                    int x = pointX + d[0];
                    int y = pointY + d[1];
                    if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y] && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                        freshOranges--;
                    }
                }
            }
        }
        return freshOranges > 0 ? -1 : round;
    }
}
