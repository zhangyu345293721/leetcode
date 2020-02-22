# encoding='utf-8'

'''
重复字符串进行分组(最传统的做法)
author:zhangyu
date:2019.8.22
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
