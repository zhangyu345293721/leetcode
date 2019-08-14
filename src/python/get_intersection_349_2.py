# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.4
   description:找到两个数组中的交集
'''


def get_intersection(arr1, arr2):
    arr = []
    s1 = set()
    for ele in arr1:
        s1.add(ele)
    s2 = set()
    for ele in arr2:
        s2.add(ele)
    for ele in s1:
        if s2.__contains__(ele):
            arr.append(ele)
    return arr


if __name__ == '__main__':
    arr1 = [1, 2, 3, 1]
    arr2 = [2, 3, 4, 2]
    arr = get_intersection(arr1, arr2)
    print(arr)
