# encoding='utf-8'

'''
/**
 * This is the solution of No. 55 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/jump-game/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def get_judge_jump_arr(arr: List[int]) -> bool:
    '''
        看是否能跳过数组
    Args:
        arr: 输入数组
    Returns:
        布尔值
    '''
    max = 0
    length = len(arr)
    for index in range(1, length):
        if arr[index - 1] == 0 and index > arr[max] + max:
            return False
        if arr[max] - (index - max) < arr[index]:
            max = index
    return True


def get_judge_jump_arr2(arr: List[int]) -> bool:
    '''
         跳远数组
    Args:
        arr: 数组
    Returns:
        是否能调到最后，布尔值
    '''''
    max = 0
    for i in range(1, len(arr)):
        if arr[i - 1] == 0 and i > max + arr[max]:
            return False
        if arr[i] > arr[max] - (i - max):
            max = i
    return True


def get_judge_jump_arr3(arr: List[int]) -> bool:
    '''
         跳远数组
    Args:
        arr: 数组
    Returns:
        是否能调到最后，布尔值
    '''''
    if len(arr) < 2:
        return True
    if arr == None or arr[0] == 0:
        return True
    for i in range(len(arr)):
        if arr[i] == 0:
            count = 0
            j = i - 1
            while j >= 0:
                if arr[j] > (j - i):
                    break
                else:
                    count += 1
                j -= 1
            if count == i:
                return False
    return True


def jump_flag(arr: List[int], i: int) -> bool:
    '''
        能不能跳过0点
    Args:
        arr: 数组
        i: 位置i
    Returns:
        布尔值
    '''
    j = i
    while j > 0:
        if arr[j] > i - j:
            return True
        j -= 1
    return False


def get_judge_jump_arr4(arr: List[int]) -> bool:
    '''
         跳远数组
    Args:
        arr: 数组
    Returns:
        是否能调到最后，布尔值
    '''''
    if len(arr) < 2:
        return True
    if arr == None or arr[0] == 0:
        return True
    for i in range(len(arr)):
        if arr[i] == 0:
            flag = jump_flag(arr, i)
            if flag:
                continue
            else:
                return flag
    return True


if __name__ == '__main__':
    arr = [2, 3, 1, 1, 4]
    flag = get_judge_jump_arr3(arr)
    print(flag)
