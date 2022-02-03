package leetcodejava.bfsdfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No.79 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/word-search
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class WordSearch79 {
    @Test
    public void searchWordsTest() {
        char[][] board =
                {
                        {'a', 'b'},
                        {'c', 'd'}
                };
        String word = "abdc";
        boolean result = exist2(board, word);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 字符串是否存在（深度优先遍历）
     *
     * @param board 二维字符
     * @param word  单词
     * @return 布尔值
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (board[i][j] == word.charAt(0) && searchHelper(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先遍历
     *
     * @param board   字符数组
     * @param word    单词
     * @param i       横坐标位置i
     * @param j       纵坐标位置j
     * @param index   单词下标
     * @param visited 是否访问过过该点
     * @return 布尔值
     */
    public boolean searchHelper(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (searchHelper(board, word, i - 1, j, index + 1, visited) ||
                searchHelper(board, word, i + 1, j, index + 1, visited) ||
                searchHelper(board, word, i, j - 1, index + 1, visited) ||
                searchHelper(board, word, i, j + 1, index + 1, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    /**
     * 字符串是否存在(广度优先遍历)
     *
     * @param board 二维字符
     * @param word  单词
     * @return 布尔值
     */
    public boolean exist2(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int len = word.length();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                int index = 0;
                if (board[i][j] == word.charAt(0)) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    index++;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] q = queue.poll();
                            if (index == len) {
                                return true;
                            }
                            for (int[] d : directions) {
                                int x = q[0] + d[0];
                                int y = q[1] + d[1];
                                if (x >= 0 && x < row && y >= 0 && y < col) {
                                    if (index < len && board[x][y] == word.charAt(index) && !visited[x][y]) {
                                        queue.add(new int[]{x, y});
                                        visited[i][j] = true;
                                        index++;
                                        if (index == len) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
