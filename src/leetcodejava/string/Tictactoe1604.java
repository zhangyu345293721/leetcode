package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.344 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 示例 1：
 * <p>
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * 示例 2：
 * <p>
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * 示例 3：
 * <p>
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * 提示：
 * <p>
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tic-tac-toe-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Tictactoe1604 {
    @Test
    public void tictactoeTest() {
        String[] board = {"O X", " XO", "X O"};
        String result = tictactoe(board);
        System.out.println(result);
        Assert.assertEquals(result, "X");

    }

    /**
     * 判断谁先赢
     *
     * @param board 字符串
     * @return str
     */
    public String tictactoe(String[] board) {
        int n = board.length;
        char[][] chs = new char[n][n];
        for (int i = 0; i < n; i++) {
            chs[i] = board[i].toCharArray();
        }
        boolean isOver = false;
        // 检查行
        for (int i = 0; i < n; i++) {
            isOver = true;
            char ch = chs[i][0];
            if (ch == ' ') {
                continue;
            }
            for (int j = 1; j < n; j++) {
                if (ch != chs[i][j]) {
                    isOver = false;
                    break;
                }
            }
            if (isOver) {
                return "" + ch;
            }
        }
        // 检查列
        for (int j = 0; j < n; j++) {
            isOver = true;
            char ch = chs[0][j];
            if (ch == ' ') {
                continue;
            }
            for (int i = 1; i < n; i++) {
                if (ch != chs[i][j]) {
                    isOver = false;
                    break;
                }
            }
            if (isOver) {
                return "" + ch;
            }
        }
        // 检查正对角
        char ch = chs[0][0];
        isOver = true;
        if (ch != ' ') {
            for (int i = 1; i < n; i++) {
                if (ch != chs[i][i]) {
                    isOver = false;
                }
            }
            if (isOver) {
                return "" + ch;
            }
        }
        // 检查斜对角线
        ch = chs[0][n - 1];
        isOver = true;
        if (ch != ' ') {
            for (int i = n - 1; i >= 1; i--) {
                if (ch != chs[i][n - 1 - i]) {
                    isOver = false;
                    break;
                }
            }
            if (isOver) {
                return "" + ch;
            }
        }
        // 检查是否有空
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chs[i][j] == ' ') {
                    return "Pending";
                }
            }
        }
        return "Draw";
    }
}
