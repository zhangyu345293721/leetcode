'''
/**
 * This is the solution of No.54 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List

def spiral_order(matrix: List[List[int]]) -> List[int]:
    '''
        顺时针打印数组
    Args:
        matrix: 二维数组
        Returns: 一维数组
    '''
    res = []
    while matrix:
        res += matrix.pop(0)
        matrix = list(zip(*matrix))[::-1]
    return res


if __name__ == '__main__':
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print(matrix.pop(0))
    print(matrix)
    print(list(zip(*matrix))[::-1])
    result = spiral_order(matrix)
    print(result)
