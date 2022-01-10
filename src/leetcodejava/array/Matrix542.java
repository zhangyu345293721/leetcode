package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No.542 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/01-matrix
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。*
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Matrix542 {
    @Test
    public void matrixTest() {
        int[][] nums = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result = updateMatrix(nums);
        System.out.println(result);
        Assert.assertEquals(result.length, 5);
    }

    /**
     * 变化二维矩阵
     *
     * @param matrix 二维数组
     * @return 新二维数组
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return matrix;
        }
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 将为0的数加入队列
                if (matrix[i][j] == 0 & !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];
                for (int[] d : directions) {
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n
                            && !visited[newX][newY]) {
                        matrix[newX][newY] = matrix[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return matrix;
    }
}
