# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.748 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shortest-completing-word
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
 *
 * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 *
 * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
 *
 * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
 *
 * 示例 1：
 *
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 说明：最短完整词应该包括 "s"、"p"、"s" 以及 "t"。对于 "step" 它只包含一个 "s" 所以它不符合条件。同时在匹配过程中我们忽略牌照中的大小写。
 *  
 * 示例 2：
 *
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 说明：存在 3 个包含字母 "s" 且有着最短长度的完整词，但我们返回最先出现的完整词。
 *  
 * 注意:
 *
 * 牌照（licensePlate）的长度在区域[1, 7]中。
 * 牌照（licensePlate）将会包含数字、空格、或者字母（大写和小写）。
 * 单词列表（words）长度在区间 [10, 1000] 中。
 * 每一个单词 words[i] 都是小写，并且长度在区间 [1, 15] 中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-completing-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:

    def get_map(self, license_plate: str) -> dict:
        '''
            字符串
        Args:
            license_plate: 输入字符串
        Returns:
            小写字符串
        '''
        str_arr = []
        for ch in license_plate.lower():
            if ch >= 'a' and ch <= 'z':
                str_arr.append(ch)
        char_dict = {}
        for ch in str_arr:
            if ch in char_dict:
                char_dict[ch] += 1
            else:
                char_dict[ch] = 1
        return char_dict

    def compare_str(self, license_map: dict, word_map: dict) -> bool:
        '''
            比较两个字符串
        Args:
            license_map: 比较串
            word_map: 待比较串
        Returns:
            布尔值
        '''
        for entry in license_map.items():
            if entry[0] not in word_map or word_map[entry[0]] < entry[1]:
                return False
        return True

    def shortest_completing_word(self, license_plate: str, words: List[str]) -> str:
        '''
            比较两个字符串
        Args:
            license_plate:比较串要进行处理
            words: 待比较数组
        Returns:
            最短字符串
        '''
        license_dict = self.get_map(license_plate)
        common_str_list = []
        for word in words:
            word_dict = self.get_map(word)
            flag = self.compare_str(license_dict, word_dict)
            if flag:
                common_str_list.append(word)
        shortest_str = common_str_list[0]
        for common_str in common_str_list:
            if len(shortest_str) > len(common_str):
                shortest_str = common_str
        return shortest_str


if __name__ == '__main__':
    license_plate = "1s3 PSt"
    words = ["step", "steps", "stripe", "stepple"]
    solution = Solution()
    shortest_str = solution.shortest_completing_word(license_plate, words)
    print(shortest_str)
    assert shortest_str == 'steps'
