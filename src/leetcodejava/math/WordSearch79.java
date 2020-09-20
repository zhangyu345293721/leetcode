package leetcodejava.math;

import org.junit.Test;

/**
 * This is the solution of No.79 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/word-search
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
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
        boolean flag = exist(board, word);
        System.out.println(flag);
    }

    /**
     * 字符串是否存在
     *
     * @param board 二维字符
     * @param word  单词
     * @return 布尔值
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        if (word == null || word.length() == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索
     */
    public boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(board, word, i - 1, j, index + 1, visited) ||
                dfs(board, word, i + 1, j, index + 1, visited) ||
                dfs(board, word, i, j - 1, index + 1, visited) ||
                dfs(board, word, i, j + 1, index + 1, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
