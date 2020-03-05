package leetcodejava.array;

/**
 * 腐烂的橘子题目
 *
 * @author: zhangyu
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
