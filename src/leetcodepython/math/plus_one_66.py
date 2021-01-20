# encoding='utf-8'

'''
/**
 * This is the solution of No. 66 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/plus-one
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def plus_one(self, digits: List[int]) -> List[int]:
        if not digits:
            return digits
        i = len(digits) - 1
        while i >= 0:
            if digits[i] != 9:
                digits[i] += 1
                return digits
            digits[i] = 0
            i -= 1
        result = [0] * (len(digits) + 1)
        result[0] = 1
        return result

if __name__ == '__main__':
    digits = [9, 9]
    solution = Solution()
    result = solution.plus_one(digits)
    print(result)
    assert result == [1, 0, 0]
