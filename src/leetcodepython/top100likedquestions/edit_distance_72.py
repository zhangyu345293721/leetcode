# encoding='utf-8'

'''
/**
 * This is the solution of No. 72 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/edit-distance/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
import numpy as np


class Solution:
    def min_distance(self, word1: str, word2: str) -> int:
        '''
            得到最小步数
        Args:
            word1: 字符串1
            word2:字符串2
        Returns:
            最小步数
        '''
        m = len(word1)
        n = len(word2)
        if m * n == 0:
            return n + m
        d = np.zeros((m + 1, n + 1), dtype=np.int)
        for i in range(m + 1):
            d[i][0] = i
        for j in range(n + 1):
            d[0][j] = j
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                left = d[i - 1][j] + 1
                down = d[i][j - 1] + 1
                left_down = d[i - 1][j - 1]
                if word1[i - 1] != word2[j - 1]:
                    left_down += 1
                d[i][j] = min(left, min(down, left_down))
        return d[n][m]


if __name__ == '__main__':
    word1 = "horse"
    word2 = "ros"
    solution = Solution()
    result = solution.min_distance(word1, word2)
    print(result)
