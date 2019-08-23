# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.22
   description:相同字符串合并
'''

def get_group_anagrams(arr):
    dic = {}
    for ele in arr:
        chs_arr = sorted(list(ele))
        print(chs_arr)
        strs = ''.join(chs_arr)
        if not dic.keys().__contains__(strs):
            dic[strs] = []
        dic[strs].append(ele)
    return dic.values()


if __name__ == '__main__':
    arr = ["eat", "tea", "tan", "ate", "nat", "bat"]
    list = get_group_anagrams(arr)
    print(list)
