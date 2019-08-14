# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.14
   description:找出第K个大的数
'''


def find_k_max_number(arr, k):
    new_arr = sorted(arr, reverse=True)
    return new_arr[k - 1]

if __name__ == '__main__':
    numbers = [1, -3, 2, 9, 4, 7, 5]
    num = find_k_max_number(numbers, 2)
    print(num)
