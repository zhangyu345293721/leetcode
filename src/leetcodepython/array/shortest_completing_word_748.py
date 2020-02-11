# -*- coding:utf-8 -*-
'''
最短包含字符串
author:zhangyu
date:2020/1/30
'''
from typing import List


def get_map(license_plate: str) -> dict:
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


def compare_str(license_map: dict, word_map: dict) -> bool:
    '''
        比较两个字符串
    Args:
        license_map: 比较串
        word_map: 待比较串
    Returns:
        布尔值
    '''
    for entry in license_map.items():
        if not word_map.keys().__contains__(entry[0]) or word_map[entry[0]] < entry[1]:
            return False
    return True


def shortest_completing_word(license_plate: str, words: List[str]) -> str:
    '''
        比较两个字符串
    Args:
        license_plate:比较串要进行处理
        words: 待比较数组
    Returns:
        最短字符串
    '''
    license_dict = get_map(license_plate)
    common_str_list = []
    for word in words:
        word_dict = get_map(word)
        flag = compare_str(license_dict, word_dict)
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
    shortest_str = shortest_completing_word(license_plate, words)
    print(shortest_str)
