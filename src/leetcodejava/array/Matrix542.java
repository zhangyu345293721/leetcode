package leetcodejava.array;

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
    public void testMatrix() {
        int[][] arr = {
                {0}, {0}, {0}, {0}, {0}
        };
        int[][] result = updateMatrix(arr);
        System.out.println(result);
    }

    /**
     * 变化二维矩阵
     *
     * @param matrix 二维数组
     * @return 新二维数组
     */
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 将为0的数加入队列
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return matrix;
    }
}
