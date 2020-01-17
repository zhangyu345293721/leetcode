# -*- coding:utf-8 -*-
'''
一个数组，是否出现次数唯一
author:zhangyu
date:2020/1/16
'''
from typing import List


def unique_number_occurrences(arr: List[int]) -> bool:
    '''
        找出数组出现独特次数
    Args:
        arr: 输入数组
    Returns:
        布尔值
    '''
    num_dict={}
    for num in arr:
       if num_dict.keys().__contains__(num):
           num_dict[num]+=1
       else:
           num_dict[num]=0
    num_set=set()
    for time in num_dict.values():
       num_set.add(time)
    return len(num_set)==len(num_dict)



if __name__ == '__main__':
    arr = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    result = unique_number_occurrences(arr)
    print(result)