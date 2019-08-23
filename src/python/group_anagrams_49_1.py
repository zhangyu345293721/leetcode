# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.22
   descriptrion:重复字符串进行分组(最传统的做法)
'''


def group_anagrams_list(strs):
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


def get_sort_str(s):
    s = sorted(list(s))
    return ''.join(s)


if __name__ == '__main__':
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    list = group_anagrams_list(strs)
    print(list)
