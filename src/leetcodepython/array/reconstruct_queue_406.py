# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/3/7
'''
from typing import List


def reconstruct_queue(people: List[List[int]]) -> List[List[int]]:
    '''
        重构队列
    Args:
        people: 人的排序
    Returns:
        重排之后的数组
    '''
    result = []
    # 第一列逆序，如果相等第二列正序
    people.sort(key=lambda x: (-x[0], x[1]))
    for cur in people:
        result.insert(cur[1], cur)
    return result


if __name__ == '__main__':
    people = [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]
    result = reconstruct_queue(people)
    print(result)
