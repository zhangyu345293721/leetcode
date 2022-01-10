package leetcodejava.top100likedquestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No.200 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/number-of-islands/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class NumberIslands200 {
    @Test
    public void numberIslandsTest() {
        char[][] chs = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '0', '0'},
                {'1', '0', '1'}
        };
        int result = numIslands4(chs);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * 计算岛屿的个数(DFS)
     *
     * @param grid 二维数组
     * @return 岛屿个数
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    searchHelper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 递归每个元素
     *
     * @param grid 二维数组
     * @param x    x坐标
     * @param y    y坐标
     */
    private void searchHelper(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return;
        }
        if (y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        searchHelper(grid, x - 1, y);
        searchHelper(grid, x + 1, y);
        searchHelper(grid, x, y - 1);
        searchHelper(grid, x, y + 1);
    }

    /**
     * 计算岛屿的个数(BFS)
     *
     * @param grid 二维数组
     * @return 岛屿个数
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    queue.add(new int[]{i, j});
                    res++;
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        for (int[] d : directions) {
                            int x = point[0] + d[0];
                            int y = point[1] + d[1];
                            if (x >= 0 && x < row && y >= 0 && y < col) {
                                if (grid[x][y] == '1' && !visited[x][y]) {
                                    queue.add(new int[]{x, y});
                                    visited[x][y] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * 计算岛屿的个数(BFS)
     *
     * @param grid 二维数组
     * @return 岛屿个数
     */
    public int numIslands4(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                    res++;
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] point = queue.poll();
                            for (int[] d : directions) {
                                int x = point[0] + d[0];
                                int y = point[1] + d[1];
                                if (x >= 0 && x < row && y >= 0 && y < col) {
                                    if (grid[x][y] == '1' && !visited[x][y]) {
                                        queue.add(new int[]{x, y});
                                        visited[x][y] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * 计算岛屿的个数(unionfind)
     *
     * @param grid 二维数组
     * @return 岛屿个数
     */
    public int numIslands3(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int waters = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        UnionFind uf = new UnionFind(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    waters++;
                } else {
                    //unionFind代码
                    for (int[] d : directions) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            uf.union(x * col + y, i * col + j);
                        }
                    }
                }
            }
        }
        return uf.getCount() - waters;
    }
}

class UnionFind {
    private int[] root = null;
    private int count = 0;

    /**
     * 初始化
     *
     * @param num 个数
     */
    public UnionFind(int num) {
        root = new int[num];
        count = num;
        for (int i = 0; i < num; i++) {
            root[i] = i;
        }
    }

    /**
     * 查看两个节点是否有关系
     *
     * @param x 节点x
     * @param y 节点y
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
            count--;
        }
    }

    /**
     * 查看某个点的根节点
     *
     * @param x 数字x
     * @return 根节点
     */
    public int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    /**
     * 获取总数量
     *
     * @return
     */
    public int getCount() {
        return count;
    }

}
