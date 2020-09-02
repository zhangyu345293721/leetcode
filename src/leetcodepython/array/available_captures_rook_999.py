# encoding='utf-8'

'''
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
'''
from typing import List


def num_rook_captures(board: List[List[str]]) -> int:
    '''
        能捕获卒的数量
    Args:
        board: 二维数组
    Returns:
        捕获数量
    '''
    start, end = 0, 0
    for i in range(8):
        for j in range(8):
            if board[i][j] == 'R':
                start, end = i, j
                break
    count = 0
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    for i in range(4):
        step = 1
        while step > 0:
            tx = start + step * dx[i]
            ty = end + step * dy[i]
            step += 1
            if tx < 0 or tx >= 8 or ty < 0 or ty >= 8 or board[tx][ty] == 'B':
                break
            if board[tx][ty] == 'p':
                count += 1
                break
    return count


if __name__ == '__main__':
    board = [[".", ".", ".", ".", ".", ".", ".", "."],
             [".", ".", ".", "p", ".", ".", ".", "."],
             [".", ".", ".", "R", ".", ".", ".", "p"],
             [".", ".", ".", ".", ".", ".", ".", "."],
             [".", ".", ".", ".", ".", ".", ".", "."],
             [".", ".", ".", "p", ".", ".", ".", "."],
             [".", ".", ".", ".", ".", ".", ".", "."],
             [".", ".", ".", ".", ".", ".", ".", "."]]
    num = num_rook_captures(board)
    print(num)
