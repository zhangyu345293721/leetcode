# encoding='utf-8'

'''
/**
 * This is the solution of No.79 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/word-search
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def word_search(self, board: List[List[str]], word: str) -> bool:
        '''
            单词查找
        Args:
            board: 字符串数组
            word: 字符串单词
        Returns:
                布尔值
        '''
        if not word or len(word) < 1:
            return True
        m, n = len(board), len(board[0])
        visited = [[False for i in range(n)] for j in range(m)]
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0] and self.dfs(board, word, i, j, 0, visited):
                    return True
        return False

    def dfs(self, board, word, i, j, index, visited):
        '''
            深度优先遍历
        Args:
            board: 二维字符串
            word: 单词
            i: 下标i
            j: 下标j
            index: 下标
            visited: 是否访问过
        Returns:
            布尔值
        '''
        if index == len(word):
            return True
        if i >= len(board) or i < 0 or j >= len(board[0]) or j < 0 or board[i][j] != word[index] or visited[i][j]:
            return False
        visited[i][j] = True
        if self.dfs(board, word, i - 1, j, index + 1, visited) or \
                self.dfs(board, word, i + 1, j, index + 1, visited) or \
                self.dfs(board, word, i, j - 1, index + 1, visited) or \
                self.dfs(board, word, i, j + 1, index + 1, visited): \
                return True
        visited[i][j] = False
        return False


if __name__ == '__main__':
    board = [
        ['a', 'b'],
        ['c', 'd']
    ]
    word = "abdc"
    solution = Solution()
    result = solution.word_search(board, word)
    print(result)
    assert result == True
