# encoding='utf-8'

'''
能捕获卒的数量
author:zhangyu
date:2020.3.27
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
