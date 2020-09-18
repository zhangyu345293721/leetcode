package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 999 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * <p>
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * <p>
 * 返回车能够在一次移动中捕获到的卒的数量。
 *  
 * 示例 1：
 * <p>
 * 输入：{{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}
 * 输出：3
 * 解释：
 * 在本例中，车能够捕获所有的卒。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AvailableCapturesRook999 {
    @Test
    public void AvailableCapturesRookTest() {

        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        int num = numRookCaptures2(board);
        System.out.println(num);

    }

    /**
     * 能捕获卒的数量
     *
     * @param board 二维数组
     * @return 捕获数量
     * “R”，“.”，“B” 和 “p”
     */
    public int numRookCaptures(char[][] board) {
        int n = board.length;
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    num = helper(board, i, j);
                }
            }
        }
        return num;
    }

    /**
     * 能捕获卒的数量
     *
     * @param board 二维数组
     * @return 捕获数量
     * “R”，“.”，“B” 和 “p”
     */
    public int numRookCaptures2(char[][] board) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    start = i;
                    end = j;
                    break;
                }
            }
        }
        int count = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int step = 0;
            while (++step > 0) {
                int tx = start + step * dx[i];
                int ty = end + step * dy[i];
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                    break;
                }
                if (board[tx][ty] == 'p') {
                    count++;
                    break;
                }
            }
        }
        return count;
    }


    /**
     * 遍历车的列和行
     *
     * @param board 二维数组
     * @param i     位置
     * @param j     位置
     * @return 数量
     */
    private int helper(char[][] board, int i, int j) {
        int num = 0;
        if (i < 0 || i >= board.length) {
            return num;
        }
        if (j < 0 || j >= board[0].length) {
            return num;
        }
        int index1 = i;
        int index2 = j;
        while (index1 >= 0) {
            if (board[index1][index2] == 'p') {
                num++;
                break;
            }
            if (board[index1][index2] == 'B') {
                break;
            }
            index1--;
        }
        index1 = i;
        while (index1 < board.length) {
            if (board[index1][index2] == 'p') {
                num++;
                break;
            }
            if (board[index1][index2] == 'B') {
                break;
            }
            index1++;
        }
        index1 = i;
        while (index2 >= 0) {
            if (board[index1][index2] == 'p') {
                num++;
                break;
            }
            if (board[index1][index2] == 'B') {
                break;
            }
            index2--;
        }
        index2 = j;
        while (index2 < board[0].length) {
            if (board[i][index2] == 'p') {
                num++;
                break;
            }
            if (board[i][index2] == 'B') {
                break;
            }
            index2++;
        }
        return num;
    }
}
