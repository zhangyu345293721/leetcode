# encoding='utf-8'

'''
   author:zhangyu
   description:寻找遗失的数字2
   date:2019.8.20
'''


def get_messing_number(arr):
    sum = 0
    n = len(arr)
    total_sum = (n + 1) * n // 2
    for i in range(len(arr)):
        sum += arr[i]
    return total_sum - sum


if __name__ == '__main__':
    arr = [9, 6, 4, 2, 3, 5, 7, 0, 1]
    messing_number = get_messing_number(arr)
    print(messing_number)
