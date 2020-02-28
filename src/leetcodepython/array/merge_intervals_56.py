# encoding='utf-8'
'''
合并区间
author:zhangyu
date:2020.2.28
'''
from typing import List

# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.20
   description:合并区间
'''

class Interval:
    def __init__(self, start, end):
        self.start = start
        self.end = end


def merge(intervals: List[Interval]) -> List[Interval]:
    '''
        合并区间
    Args:
        intervals: 区间对象
    Returns:
        区间集合
    '''
    intervals.sort(key=lambda x: x.start)
    merged = []
    for interval in intervals:
        if not merged or merged[-1].end < interval.start:
            merged.append(interval)
        else:
            merged[-1].end = max(merged[-1].end, interval.end)
    return merged


if __name__ == '__main__':
    i1, i2 = Interval(1, 2), Interval(1, 4)
    arr = []
    arr.extend([i1, i2])
    merged = merge(arr)
    print(merged[0].start, merged[0].end)
