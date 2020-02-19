# encoding='utf-8'

'''
一个点到另一个点的所有路径
author:zhangyu
date:2020.2.17
'''
import numpy as np


def unique_paths(m: int, n: int) -> int:
    '''
        独特的路径
    Args:
        m:数字m
        n:数字n
    Returns:
        返回数量
    '''
    if m == 0 or n == 0:
        return 0
    if m == 1 or n == 1:
        return 1
    dp = np.zeros((m + 1, n + 1))
    for i in range(m + 1):
        dp[i][0] = 1
    for j in range(n + 1):
        dp[0][j] = 1
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    return dp[m - 1][n - 1]


if __name__ == '__main__':
    m, n = 7, 3
    paths = unique_paths(m, n)
    print(paths)
