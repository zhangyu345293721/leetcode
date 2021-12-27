package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No.16.19 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/permutations
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。
 * 池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pond-sizes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PondSize1619 {

    @Test
    public void pondSizeTest() {
        int[][] land = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        int[] res = pondSizes2(land);
        System.out.println(Arrays.toString(res));
        Assert.assertEquals(res.length, 3);
    }

    /**
     * 池塘大小
     *
     * @param land 陆地
     * @return 陆地size
     */
    public int[] pondSizes(int[][] land) {
        if (land == null || land.length < 1) {
            return new int[0];
        }
        int count = 0;
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    count = searchHelper(land, i, j);
                    resList.add(count);
                }
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    /**
     * @param land 陆地
     * @param i    坐标i
     * @param j    坐标j
     * @return 数量
     */
    public int searchHelper(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        int count = 1;
        count += searchHelper(land, i + 1, j);
        count += searchHelper(land, i - 1, j);
        count += searchHelper(land, i, j + 1);
        count += searchHelper(land, i, j - 1);
        count += searchHelper(land, i + 1, j + 1);
        count += searchHelper(land, i - 1, j + 1);
        count += searchHelper(land, i - 1, j - 1);
        count += searchHelper(land, i + 1, j - 1);
        return count;
    }

    /**
     * 池塘大小
     *
     * @param land 陆地
     * @return 陆地size
     */
    public int[] pondSizes2(int[][] land) {
        if (land == null || land.length < 1) {
            return new int[0];
        }
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> resList = new ArrayList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    int count = 0;
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    count++;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] p = queue.poll();
                            for (int[] d : directions) {
                                int x = d[0] + p[0];
                                int y = d[1] + p[1];
                                if (x >= 0 && x < land.length && y >= 0 && y < land[0].length && !visited[x][y] && land[x][y] == 0) {
                                    queue.add(new int[]{x, y});
                                    visited[x][y] = true;
                                    count++;
                                }
                            }
                        }
                    }
                    resList.add(count);
                }
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        Arrays.sort(res);
        return res;
    }
}
