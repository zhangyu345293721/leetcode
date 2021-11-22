# encoding='utf-8'

'''
/**
 * This is the solution of No. 77 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/combinations
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def search_num(self, n: int, k: int, num: int, result: List[List[int]], temp: List[int]) -> None:
        '''
            深度优先遍历
        Args:
            n: 1-n之间的数
            k: 选择k个数
            num:当前数字
            result:结果链表
            temp:当前链表
        Returns:
            结果链表
        '''
        if len(temp) == k:
            # 复制元素
            result.append(temp[:])
            return
        i = num
        while i <= n:
            temp.append(i)
            # 加1是为了不重复选数
            self.search_num(n, k, i + 1, result, temp)
            temp.pop()
            i += 1

    def combine(self, n: int, k: int) -> List[List[int]]:
        '''
            数组排列组合
        Args:
            n: 1-n之间的数
            k: 选择k个数
        Returns:
            排列组合之后结果
        '''
        result = []
        temp = []
        self.search_num(n, k, 1, result, temp)
        return result

    def combine2(self, n: int, k: int) -> List[List[int]]:
        '''
            数组排列组合
        Args:
            n: 1-n之间的数
            k: 选择k个数
        Returns:
            排列组合之后结果
        '''
        result = []
        temp = []
        self.search_helper(n, k, 1, result, temp)
        return result

    def search_helper(self, n: int, k: int, step: int, result: List[List[int]], temp: List[int]) -> None:
        '''
            递归调用
        Args:
            n: n个数
            k: 选择的k个数
            step: 阶段，在哪一步
            result:结果集
            temp:临时结果集
        Returns:
            None
        '''
        if len(temp) == k:
            result.append(temp[:])
            return
        if step == n + 1:
            return
        # 不选择该数放入链表
        self.search_helper(n, k, step + 1, result, temp)
        # 选择该数放入到链表
        temp.append(step)
        self.search_helper(n, k, step + 1, result, temp)
        # 回退操作
        temp.pop()


if __name__ == '__main__':
    n, k = 4, 2
    solution = Solution()
    result = solution.combine2(n, k)
    print(result)
    assert result == [[3, 4], [2, 4], [2, 3], [1, 4], [1, 3], [1, 2]]
