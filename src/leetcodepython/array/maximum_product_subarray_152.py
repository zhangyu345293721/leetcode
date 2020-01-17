# encoding='utf-8'

'''
计算最大下标乘积
author:zhangyu
date:2020.1.17
'''
from typing import List

def max_product(arrs: List[int]) -> int:
    '''
        数组乘积最大值
    Args:
        arrs: 数组
    Returns:
        乘积
    '''
    max_num = arrs[0]
    min_num = arrs[0]
    result = arrs[0]
    for i in range(1, len(arrs)):
        temp = max_num
        max_num = max(max(max_num * arrs[i], min_num * arrs[i]), arrs[i])
        min_num = min(min(temp * arrs[i], min_num * arrs[i]), arrs[i])
        if max_num > result:
            result = max_num
    return result


if __name__ == '__main__':
    arrs = [2, 3, -2, 4]
    num = max_product(arrs)
    print(num)
