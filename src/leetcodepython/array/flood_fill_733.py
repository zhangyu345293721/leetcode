# encoding='utf-8'

'''
author:zhangyu
date:2020.1.31
description:找到两个数组中的交集
'''
from typing import List


def flood_fill_method(image: List[List[int]], sr: int, sc: int, old_color: int, new_color: int) -> List[List[int]]:
    '''
       数组转变
   Args:
       image:二维数组
       sr: 输入sr
       sc: 输入sc
       old_color:老颜色
       new_color: 新颜色
   Returns:
       变换后的数组
   '''
    row = len(image)
    col = len(image[0])
    if (sr < 0 or sr >= row) or (sc < 0 or sc >= col) or image[sr][sc] != old_color or image[sr][sc] == new_color:
        return image
    image[sr][sc] = new_color
    flood_fill_method(image, sr + 1, sc, old_color, new_color)
    flood_fill_method(image, sr, sc + 1, old_color, new_color)
    flood_fill_method(image, sr - 1, sc, old_color, new_color)
    flood_fill_method(image, sr, sc - 1, old_color, new_color)
    return image


def flood_fill(image: List[List[int]], sr: int, sc: int, new_color: int) -> List[List[int]]:
    return flood_fill_method(image, sr, sc, image[sr][sc], new_color)


if __name__ == '__main__':
    image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
    sr = 1
    sc = 1
    new_color = 2
    result = flood_fill(image, sr, sc, new_color);
    print(result)
