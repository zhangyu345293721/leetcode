# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.22
   description:找出数组中重复的数字2
'''


def find_duplicate_number(arr):
    s = set()
    for i in range(len(arr)):
        if s.__contains__(arr[i]):
            return arr[i]
        else:
            s.add(arr[i])
    return -1


if __name__ == '__main__':
    arr = [3, 2, 1, 2, 4]
    num = find_duplicate_number(arr)
    print(num)
