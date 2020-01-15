# encoding='utf-8'

'''
   author:zhangyu
   date:2020.1.9
   description:组合数
'''


def combination_sum(arr, target):
    '''
        数组
    Args:
        arr: 数组
        target: 目标值
    Returns:
        组合链表
    '''
    result = []
    current = []
    arr.sort()
    helper(arr, target, result, current, 0)
    return result


def helper(arr, target, result, current, param):
    '''
        递归获取结果
    Args:
        arr: 数组
        target:目标
        result:结果集
        current:当前结果
        param:下标
    '''
    for i in range(len(arr)):
        if arr[i] > target:
            break
        current.append(arr[i])
        if target - arr[i] == 0:
            result.append(current)
        else:
            helper(arr, target - arr[i], result, i)
        current.remove(len(current) - 1)
