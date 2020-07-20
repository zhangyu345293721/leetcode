# encoding='utf-8'

'''
三个数相加
author:zhangyu
date:2020.7.17
'''
import  numpy as np
def num_trees(n: int) -> int:
    dp = np.zeros(n+1)
    dp[0] = 1
    for i in range(1, n + 1):
        l, r, count = 0, i - 1, 0
        while i < r:
            count += dp[l] * dp[r]
            l += 1
            r -= 1
        count *= 2
        if l == r:
            count += dp[l] * dp[l]
        dp[i] = count
    return dp[n]


if __name__ == '__main__':
    num=3
    result = num_trees(3)
    print(result)
