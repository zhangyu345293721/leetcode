# encoding='utf-8'

'''
   author:zhangyu
   description:利用异或找出数组中出现一次的数
   date:2019.8.3
'''


def get_single_number2(arr):
    single_number = arr[0]
    for i in range(1, len(arr)):
        single_number = single_number ^ arr[i]
    return single_number


if __name__ == '__main__':
    arr = [2, 3, 2, 4, 4]
    single_number = get_single_number2(arr)
    print(single_number)
