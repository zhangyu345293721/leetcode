# encoding='utf-8'

'''
/**
 * This is the solution of No. 836 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/rectangle-overlap
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 *
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 *
 * 给出两个矩形，判断它们是否重叠并返回结果。
 *
 * 示例 1：
 *
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false 
 * 提示：
 *
 * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 * x 轴默认指向右，y 轴默认指向上。
 * 你可以仅考虑矩形是正放的情况。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def is_rectangle_overlap(rec1: List[int], rec2: List[int]) -> bool:
    '''
        判断两个矩形是否重叠
    Args:
        rec1: 矩形1
        rec2: 矩形2
    Returns:
        是否重叠布尔值
    '''
    x11, y11, x12, y12 = rec1[0], rec1[1], rec1[2], rec1[3]
    x21, y21, x22, y22 = rec2[0], rec2[1], rec2[2], rec2[3]
    y_flag = not (y21 >= x12 or y22 <= y11)
    x_flag = not (x21 >= x12 or x22 <= x11)
    return x_flag and y_flag


if __name__ == '__main__':
    rec1 = [5, 15, 8, 18]
    rec2 = [0, 3, 7, 9]
    flag = is_rectangle_overlap(rec1, rec2)
    print(flag)
