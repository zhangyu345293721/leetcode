# encoding='utf-8'

'''
/**
 * This is the solution of No. 49 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/group-anagrams
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author  zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def group_anagrams1(self, strs: List[str]) -> List[str]:
        '''
            字符串
        Args:
            strs: 字符串数组
        Returns:
            链表
        '''
        str_dict = {}
        for ele in strs:
            sorted_str = self.get_sort_str(ele)
            if sorted_str not in str_dict:
                str_dict[sorted_str] = []
            str_dict[sorted_str].append(ele)
        return list(str_dict.values())

    def get_sort_str(self, s: str) -> str:
        '''
            对字符串进行排序
        Args:
            s: 字符串
        Returns:
            排序后字符串
        '''
        if not s or len(s) < 1:
            return None
        s = sorted(list(s))
        return ''.join(s)

    def group_anagrams2(self, strs: List[str]) -> List[str]:
        '''
            字符串
        Args:
            strs: 字符串数组
        Returns:
            链表
        '''
        words_dict = {}
        for str in strs:
            word_key = self.word_to_num(str)
            if word_key not in words_dict:
                words_dict[word_key] = []
            words_dict[word_key].append(str)
        return list(words_dict.values())

    def word_to_num(self, s: str) -> int:
        '''
            将字符串转成素数
        Args:
            s:将字符串转成数字
        Returns:
            质数
        '''
        # 26个字母，定义26个素数
        prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103]
        key = 1
        for ch in s:
            key *= prime[ord(ch) - ord('a')]
        return key


if __name__ == '__main__':
    words = ["eat", "tea", "tan", "ate", "nat", "bat"]
    solution = Solution()
    result = solution.group_anagrams1(words)
    print(result)
    assert result == [['eat', 'tea', 'ate'], ['tan', 'nat'], ['bat']]
