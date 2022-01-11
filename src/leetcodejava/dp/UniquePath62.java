package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No.62 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/unique-paths/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class UniquePath62 {
    @Test
    public void uniquePathTest() {
        int n = 13;
        int m = 12;
        // 1352078
        int result = paths(m, n);
        // 193536720
        System.out.println(result);
        Assert.assertEquals(result, 1352078);
    }

    /**
     * 总的种数
     *
     * @param m 数字m
     * @param n 数字n
     * @return 次数
     */
    private int paths(int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        // 定义数组
        int[][] dp = new int[m][n];
        // 初始化数组
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 状态转移方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    private int count = 0;

    /**
     * 总的种数
     *
     * @param m 数字m
     * @param n 数字n
     * @return 次数
     */
    private int paths2(int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        searchHelper(visited, 0, 0);
        return count;
    }

    /**
     * 深度优先遍历
     *
     * @param visited 是否访问
     * @param i       坐标i
     * @param j       坐标j
     */
    private void searchHelper(boolean[][] visited, int i, int j) {
        int row = visited.length;
        int col = visited[0].length;
        if (i == row - 1 && j == col - 1) {
            count++;
        }
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        searchHelper(visited, i + 1, j);
        searchHelper(visited, i, j + 1);
        visited[i][j] = false;
    }

    /**
     * 总的种数(广度优先遍历)
     *
     * @param m 数字m
     * @param n 数字n
     * @return 次数
     */
    private int paths3(int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int pointX = point[0];
                int pointY = point[1];
                visited[pointX][pointY] = true;
                if (pointX == m - 1 && pointY == n - 1) {
                    count++;
                }
                for (int[] d : directions) {
                    int x = pointX + d[0];
                    int y = pointY + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return count;
    }
}
