# encoding='utf-8'

'''
   author:zhangyu
   data:2019.8.23
   description: 相同字符串合并
'''


def group_anagrams(strs):
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
    arr = ["eat", "tea", "tan", "ate", "nat", "bat"]
    list = group_anagrams(arr)
    print(list)
