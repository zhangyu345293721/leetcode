# encoding='utf-8'

'''
/**
 * This is the solution of No.365 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/water-and-jug-problem
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-and-jug-problem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
import math


class Solution:
    def can_measure_water(self, x: int, y: int, z: int) -> bool:
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
    solution = Solution()
    num = solution.can_measure_water(x=3, y=4, z=5)
    print(num)
    solution = Solution()
    assert num == True
