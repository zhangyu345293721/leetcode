# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.4
   description:找到两个数组中的交集
'''


def get_intersection(arr1, arr2):
    arr1.sort();
    arr2.sort();
    arr = []
    i = 0
    j = 0
    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            i += 1
        elif arr1[i] > arr2[j]:
            j += 1
        else:
            arr.append(arr1[i])
            i += 1
            j += 1
    return arr


if __name__ == '__main__':
    arr1 = [1, 2, 3, 1]
    arr2 = [2, 3, 4, 2]
    arr = get_intersection(arr1, arr2)
    print(arr)
