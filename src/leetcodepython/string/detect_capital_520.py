# encoding='utf-8'

'''
/**
 * This is the solution of No.306 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/additive-number/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * <p>
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * <p>
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * <p>
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 * <p>
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def detect_capital_use(self, word: str) -> bool:
        '''
            检查大小写
        Args:
            word: 单词
        Returns:
            布尔值
        '''
        if len(word) <= 1:
            return True
        first_char_flag = ord(word[0]) < 97
        second_char_flag = ord(word[1]) < 97
        if not first_char_flag and second_char_flag:
            return False
        for i in range(2, len(word)):
            char_flag = ord(word[i]) < 97
            if not second_char_flag and char_flag:
                return False
            if second_char_flag and not char_flag:
                return False
        return True

if __name__ == '__main__':
    s = 'USA'
    solution = Solution()
    result = solution.detect_capital_use(s)
    print(result)
    assert result == True
