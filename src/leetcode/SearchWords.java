package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu   这个做法比较麻烦，需要考虑的细节比较多，做不下去了
 * @version V1.0
 * @ClassName: SearchWords
 * @Description: TOTO
 * @date 2018/12/7 16:16
 **/

// 匹配字符包含问题
public class SearchWords {
    @Test
    public void fun() {
        char[][] board =
                {
                        {'a', 'b'},
                        {'c', 'd'}
                };
        String word = "abcd";
        boolean flag = searchWords(board, word);
        /*for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
        }*/
        System.out.println(flag);
    }

    private boolean searchWords(char[][] board, String word) {
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (!isExist(chs[i], board)) {
                return false;
            }
        }
        return true;
    }

    private boolean isExist(char c, char[][] chars) {
        /*
           后续该更还要加入一些一个数组来判断每一位的相对位置,这种做法比较麻烦
         */
        int[][] index=new int[chars.length][chars[0].length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == c) {
                    chars[i][j] = '@';
                    return true;
                }
            }
        }
        return false;
    }
}
