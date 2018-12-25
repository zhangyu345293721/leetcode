package leetcode;

import org.junit.Test;

/**
 * @author zhangyu   这个做法比较麻烦，需要考虑的细节比较多，做不下去了
 * @version V1.0
 * @ClassName: SearchWords
 * @Description: TOTO
 * @date 2018/12/7 16:16
 **/

// 匹配字符包含问题
public class SearchWords2 {
    @Test
    public void fun() {
        char[][] board =
                {
                        {'a', 'b'},
                        {'c', 'd'}
                };
        String word = "abcd";
        boolean flag = exist(board, word);
        /*for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
        }*/
        System.out.println(flag);
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        if (word == null || word.length() == 0) {
            return true;
        }
        for (int i = 0 ; i < board.length; i ++){
            for (int j = 0 ; j < board[0].length ; j++){
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index,  boolean[][] visited) {
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
