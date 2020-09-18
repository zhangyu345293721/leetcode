package leetcodejava.array;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No. 1162 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * 示例 1：
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 * <p>
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *  
 * <p>
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AsFarLandPossible1162 {
    /**
     * 1）先找到所有陆地
     * 2）然后再遍历陆地
     * 3）返回最短距离
     */
    @Test
    public void asFarLandPossibleTest() {
        int[][] arr = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int num = maxDistance(arr);
        System.out.println(num);
    }

    /**
     * 求最大距离
     *
     * @param grid 二维数组
     * @return 最大
     */
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        // 广度优先搜索
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j], y = point[1] + dy[j];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1) {
                        continue;
                    }
                    grid[x][y] = 1;
                    queue.add(new int[]{x, y});
                }
            }
            count++;
        }
        // count要减1，因为最后一个到达的点进队列，就已经终止，又重复遍历了一次
        return count - 1;
    }
}
