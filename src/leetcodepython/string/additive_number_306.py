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
    flag = False
    def is_additive_number(self, num: str) -> bool:
        '''
            判断一个字符串是不是累加树
        Args:
            num: 字符串数字
        Returns:
            布尔值
        '''
        if len(num) < 3:
            return False
        i = 0
        num_length = len(num)
        for j in range(i + 1, num_length):
            for k in range(j + 1, num_length):
                self.helper(i, j, k, num)
                if self.flag:
                    return self.flag
        return self.flag

    def helper(self, i: int, j: int, k: int, num: str) -> None:
        '''
            累加树遍历帮助类
        Args:
            i:下标i
            j: 下标j
            k:下标k
            num:字符数字
        Returns:
            None
        '''
        # 剪枝操作
        if num[i] == '0' and j - i > 1:
            return
        if num[j] == '0' and k - j > 1:
            return
        if k >= len(num):
            self.flag = True
            return
        num1 = int(num[i:j])
        num2 = int(num[j:k])
        total = num1 + num2
        end = k + len(str(total))
        # 剪枝操作
        if total != int(num[k:end]):
            return
        if end > len(num):
            return
        self.helper(j, k, end, num)


if __name__ == '__main__':
    num = '0235813'
    solution = Solution()
    result = solution.is_additive_number(num)
    print(result)
    assert result == False
