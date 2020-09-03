# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 139 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/word-break/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */4
'''
from typing import List


def word_break(s: str, word_dict: List[str]) -> bool:
    '''
        判断一个单词是不是分成这个数组
    Args:
        s: 字符串
        word_dict: 字符表
    Returns:
        布尔值
    '''
    length = len(word_dict)
    f = [False for i in range(length + 1)]
    f[0] = True
    for i in range(1, length + 1):
        for j in range(i):
            if f[j] and (s[j:i] in word_dict):
                f[i] = True
                break;
    return f[length]


if __name__ == '__main__':
    s = "leetcode"
    word_dict = ["leet", "code"]
    flag = word_break(s, word_dict)
    print(flag)
