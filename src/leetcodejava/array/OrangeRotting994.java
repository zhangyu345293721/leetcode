package leetcodejava.array;

/**
 * This is the solution of No.994 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/rotting-oranges
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 示例 1：
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 *
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class OrangeRotting994 {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2 && !visited[i][j]) {
                    helper(grid, i, j, visited);
                    count++;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;

    }

    private void helper(int[][] grid, int i, int j, boolean[][] visited) {
        if (grid == null) {
            return;
        }
        if (i >= grid.length) {
            return;
        }
        if (j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
        }
        visited[i][j] = true;
        helper(grid, i + 1, j, visited);
        helper(grid, i - 1, j, visited);
        helper(grid, i, j + 1, visited);
        helper(grid, i, j - 1, visited);
    }
}
