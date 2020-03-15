package leetcodejava.math;

import org.junit.Test;

/**
 * 匹配字符包含问题
 *
 * @author zhangyu
 **/
public class WordSearch79 {
    @Test
    public void testSearchWords() {
        char[][] board =
                {
                        {'a', 'b'},
                        {'c', 'd'}
                };
        String word = "abcd";
        boolean flag = exist(board, word);

        System.out.println(flag);
    }

    /**
     * 字符串是否存在
     *
     * @param board 二维字符
     * @param word  单词
     * @return
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
