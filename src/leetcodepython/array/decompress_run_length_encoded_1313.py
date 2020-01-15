'''
解压链表
author:zhangyu
date:2020.1.15
'''
from typing import List


def decompress_RLE_list(nums: List[int]) -> int:
    '''
        解压链表
    Args:
        nums: 数组
    Returns:
        新链表
    '''
    i = 0
    decompress_arr = []
    while i < len(nums) - 1:
        time = nums[i]
        num = nums[i + 1]
        for j in range(time):
            decompress_arr.append(num)
        i += 2
    return decompress_arr


if __name__ == '__main__':
    nums = [1, 2, 3, 4]
    arr = decompress_RLE_list(nums);
    print(arr)
