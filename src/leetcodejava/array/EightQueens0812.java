package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.0812 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/eight-queens-lcci
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 注意：本题相对原题做了扩展
 *
 * 示例:
 *
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class EightQueens0812 {
    @Test
    public void EightQueensTest() {
        int n = 4;
        List<List<String>> result = solveNQueens(n);
        Assert.assertEquals(result.size(), 2);
    }

    private List<List<String>> result = new ArrayList();

    /**
     * 八皇后问题
     *
     * @param n 八皇后数
     * @return 结果链表
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        backtrack(0, board, n);
        return result;
    }

    /**
     * 递归回溯求解
     */
    private void backtrack(int row, char[][] board, int n) {
        // 结束条件，得到可⾏解
        if (row == n) {
            List<String> snapshot = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                snapshot.add(new String(board[i]));
            }
            result.add(snapshot);
            return;
        }
        for (int col = 0; col < n; ++col) { //每⼀⾏都有n中放法
            if (isOk(board, n, row, col)) { //可选列表
                board[row][col] = 'Q'; //做选择，第row⾏的棋⼦放到了col列
                backtrack(row + 1, board, n); //考察下⼀⾏
                board[row][col] = '.'; //恢复选择
            }
        }
    }

    /**
     * 检查该位置放皇后是否合法
     */
    private boolean isOk(char[][] board, int n, int row, int col) {
        // 检查列是否有冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查行是否冲突
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        // 检查右上对⻆线是否有冲突
        int i = row - 1;
        int j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        // 检查左上对⻆线是否有冲突
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
