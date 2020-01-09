# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.22
   descriptrion:重复字符串进行分组(最传统的做法)
'''


def group_anagrams_list(strs):
    '''
        字符串
    Args:
        strs: 字符串数组
    Returns:
        链表

    '''
    str_set = set()
    new_list = []
    for s in strs:
        str_set.add(get_sort_str(s))
    for ele in str_set:
        list = []
        for i in range(len(strs)):
            sort_s = get_sort_str(strs[i])
            if ele.__eq__(sort_s):
                list.append(strs[i])
        new_list.append(list)
    return new_list


def get_group_anagrams(arr):
    '''
        字符串
    Args:
        strs: 字符串数组
    Returns:
        链表

    '''
    dic = {}
    for ele in arr:
        chs_arr = sorted(list(ele))
        print(chs_arr)
        strs = ''.join(chs_arr)
        if not dic.keys().__contains__(strs):
            dic[strs] = []
        dic[strs].append(ele)
    return dic.values()


def get_sort_str(s):
    s = sorted(list(s))
    return ''.join(s)


def group_anagrams3(strs):
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
        if not dic.keys().__contains__(key):
            dic[key] = []
        dic[key].append(str)
    return dic.values()


def invert_to_num(str):
    # 26个字母，定义26个素数
    prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103]
    chs = list(str)
    value = 1
    for ch in chs:
        value *= prime[ord(ch) - ord('a')]
    return value


if __name__ == '__main__':
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    list = group_anagrams_list(strs)
    print(list)
