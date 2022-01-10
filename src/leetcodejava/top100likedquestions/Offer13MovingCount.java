package leetcodejava.top100likedquestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of Offer.13 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Offer13MovingCount {

    @Test
    public void offer13MovingCountTest() {
        int m = 2, n = 3, k = 1;
        int result = movingCount(m, n, k);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * 移动次数
     *
     * @param m m位置
     * @param n n位置
     * @param k 不能大于k的值
     * @return 移动格子数
     */
    public int movingCount(int m, int n, int k) {
        if (n < 0 || m < 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        count++;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] d : directions) {
                    int x = point[0] + d[0];
                    int y = point[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && check(x, y, k)) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int count = 0;
    private boolean[][] visited;

    /**
     * 计算机器人能移动的范围
     *
     * @param m 行m
     * @param n 列n
     * @param k 数值k
     * @return 移动数量
     */
    public int movingCount2(int m, int n, int k) {
        visited = new boolean[m][n];
        searchHelper(0, 0, m, n, k);
        return count;
    }

    /**
     * 搜索帮助类
     *
     * @param i 位置i--
     * @param j 位置j
     * @param m m行
     * @param n n列
     * @param k 数值k
     */
    private void searchHelper(int i, int j, int m, int n, int k) {
        if (i < 0 || i >= m) {
            return;
        }
        if (j < 0 || j >= n) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (!check(i, j, k)) {
            return;
        }
        visited[i][j] = true;
        count++;
        searchHelper(i - 1, j, m, n, k);
        searchHelper(i + 1, j, m, n, k);
        searchHelper(i, j - 1, m, n, k);
        searchHelper(i, j + 1, m, n, k);
    }

    /**
     * 判断是否满足条件
     *
     * @param i 坐标i
     * @param j 坐标j
     * @param k k值
     * @return 布尔值
     */
    public boolean check(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }

}
