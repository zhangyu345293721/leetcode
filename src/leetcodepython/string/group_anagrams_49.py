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


def group_anagrams(strs: List[str]) -> List[str]:
    '''
        字符串
    Args:
        strs: 字符串数组
    Returns:
        链表
    '''
    str_set = set()
    result = []
    for s in strs:
        str_set.add(get_sort_str(s))
    for ele in str_set:
        list_str = []
        for s in strs:
            sort_s = get_sort_str(s)
            if ele == sort_s:
                list_str.append(s)
        result.append(list_str)
    return result


def group_anagrams2(arr: List[str]) -> List[str]:
    '''
        字符串
    Args:
        strs: 字符串数组
    Returns:
        链表
    '''
    dic = {}
    for ele in arr:
        sorted_str = get_sort_str(ele)
        if str not in dic:
            dic[sorted_str] = []
        dic[sorted_str].append(ele)
    return dic.values()


def get_sort_str(s: str) -> str:
    '''
        对字符串进行排序
    Args:
        s: 字符串
    Returns:
        排序后字符串
    '''
    s = sorted(list(s))
    return ''.join(s)


def group_anagrams3(strs: List[str]) -> List[str]:
    '''
        字符串
    Args:
        strs: 字符串数组
    Returns:
        链表
    '''
    dic = {}
    for str in strs:
        key = invert_to_num(str)
        if key not in dic:
            dic[key] = []
        dic[key].append(str)
    return list(dic.values())


def invert_to_num(s: str) -> int:
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
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    str_list = group_anagrams3(strs)
    print(str_list)
