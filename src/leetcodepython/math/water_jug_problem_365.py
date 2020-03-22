# encoding='utf-8'

'''
最完美的平方数
author:zhangyu
date:2020.2.12
'''
import math


def can_measure_water(x: int, y: int, z: int) -> bool:
    '''
        是否可以测量体积
    Args:
        x: x毫升
        y: y毫升
        z: z毫升
    Returns:
        布尔值
    '''
    if x + y < z:
        return False
    if z == 0:
        return True
    if x == 0 or y == 0:
        return x + y == z
    return z % math.gcd(x, y) == 0


if __name__ == '__main__':
    num = can_measure_water(x=3, y=4, z=5)
    print(num)
