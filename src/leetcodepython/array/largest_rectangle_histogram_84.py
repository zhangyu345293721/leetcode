# encoding='utf-8'

'''
计算最大矩形体积
author:zhangyu
date:2020.1.17
'''


def largest_rectangle_histogram(arrs):
    '''
        计算最大矩形长度
    Args:
        arrs: 数组长度
    Returns:
        矩形最大面积
    '''
    if arrs == None or arrs.__len__() < 2:
        return 0
    stack = []
    max_area = 0
    index = 0
    while index < len(arrs):
        if len(stack) < 1 or (index < arrs.__len__() and arrs[index] >= arrs[stack[-1]]):
            stack.append(index)
            index += 1
        else:
            top = stack.pop()
            witdh = None
            if stack.__len__() < 1:
                witdh = index
            else:
                witdh = index - stack[-1] - 1
                max_area = max(max_area, witdh * arrs[top])
    return max_area


if __name__ == '__main__':
    arrs = [2, 1, 5, 6, 2, 3]
    max_area = largest_rectangle_histogram(arrs)
    print(max_area)
