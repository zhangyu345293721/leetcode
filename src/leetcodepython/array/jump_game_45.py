# encoding='utf-8'
'''
最小步数跳过数组
author:zhangyu
'''
from typing import List


def jump(nums: List[int]) -> int:
    '''
        数组
    Args:
       nums: 数组
    Returns:
        最小步数
    '''
    length = len(nums)
    end = 0  # 这一跳截止点
    max_pos = 0  # 下一跳最远点
    res = 0
    for i in range(length - 1):
        max_pos = max(max_pos, i + nums[i])
        if i == end:
            end = max_pos
            res += 1
    return res

if __name__ == '__main__':
    nums = [2, 3, 1, 1, 4]
    jump = jump(nums)
    print(jump)