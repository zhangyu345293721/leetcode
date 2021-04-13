# encoding='utf-8'

'''
/**
 * This is the solution of No. 461 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/hamming-distance/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */'''


class Solution:
    def hamming_distance(self, x: int, y: int) -> int:
        '''
            汉明距离
        Args:
            x: 数值x
            y: 数值y
        Returns:
            距离
        '''
        c = x ^ y
        res = 0
        while c > 0:
            res += (c & 1)
            c = c >> 1
        return res


if __name__ == '__main__':
    x = 1
    y = 4
    solution = Solution()
    res = solution.hamming_distance(x, y)
    print(res)
    assert res == 2
