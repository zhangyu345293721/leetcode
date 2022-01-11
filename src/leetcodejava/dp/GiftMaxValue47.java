package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.offer47 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class GiftMaxValue47 {

    @Test
    public void giftMaxValueTest() {
        int[][] grid = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int result = maxValue2(grid);
        System.out.println(result);
        Assert.assertEquals(result, 12);
    }

    private int maxValue = Integer.MIN_VALUE;

    /**
     * 获取礼物最大值
     *
     * @param grid 二维网格
     * @return 礼物最大值
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        searchHelper(visited, grid, 0, 0, 0);
        return maxValue;
    }

    /**
     * 深度优先遍历
     *
     * @param visited 是否访问
     * @param grid    二维数组
     * @param i       位置i
     * @param j       位置j
     * @param sum     值sum
     */
    public void searchHelper(boolean[][] visited, int[][] grid, int i, int j, int sum) {
        int row = grid.length;
        int col = grid[0].length;
        // 递归结束条件1、到达右下角的位置
        if (i == row - 1 && j == col - 1) {
            maxValue = Math.max(maxValue, sum + grid[row - 1][col - 1]);
            return;
        }
        // 递归结束条件2、数组越界或者到达已经遍历过的数组位置
        if (i < 0 || i > row - 1 || j < 0 || j > col - 1 || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        sum += grid[i][j];
        searchHelper(visited, grid, i + 1, j, sum);// 向下递归
        searchHelper(visited, grid, i, j + 1, sum);// 向右递归
        // 回溯
        visited[i][j] = false;
        sum -= grid[i][j];
    }


    /**
     * 获取礼物最大值(动态规划)
     *
     * @param grid 二维网格
     * @return 礼物最大值
     */
    public int maxValue2(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        // 初始化
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][col - 1];
    }

    /**
     * 获取礼物最大值(动态规划不改变原来grid数组)
     *
     * @param grid 二维网格
     * @return 礼物最大值
     */
    public int maxValue3(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        // 初始化数组
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        // 状态转移方程
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
