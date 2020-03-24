# encoding='utf-8'

'''
最完美的平方数
author:zhangyu
date:2020.2.12
'''
import sys

def num_squares(num: int) -> int:
    '''
        找出一个数是平方的和
    Args:
        num: 数字
    Returns:
        数字和
    '''
    dp = [0] * (num + 1)
    for i in range(1, num + 1):
        min_value = sys.maxsize
        j = 1
        while j * j <= i:
            min_value = min(min_value, 1 + dp[i - j * j])
            j += 1
        dp[i] = min_value
    return dp[i]

if __name__ == '__main__':
    num = 18
    num = num_squares(num)
    print(num)
