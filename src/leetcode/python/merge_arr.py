# encoding='utf-8'
'''
   author:zhangyu
   descrption:对从小到大排列的数据进行合并（包含有重复的数字）
   date:2019.7.21
'''


def get_merge_arr(arr1, arr2):
    new_arr = []
    i = 0
    j = 0
    while i < len(arr1) and j < len(arr2):
        if arr1[i] <= arr2[j]:
            new_arr.append(arr1[i])
            i += 1
        else:
            new_arr.append(arr2[j])
            j += 1
    while i < len(arr1):
        new_arr.append(arr1[i])
        i += 1
    while j < len(arr2):
        new_arr.append(arr2[j])
        j += 1
    return new_arr


if __name__ == '__main__':
    arr1 = [1, 2, 5, 7, 9]
    arr2 = [2, 3, 4, 8, 11]
    new_arr = get_merge_arr(arr1, arr2)
    print(new_arr)
