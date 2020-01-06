# encoding='utf-8'

'''
   author:zhangyu
   description:找出一个数组中出现的单独一个数
   date:2019.8.3
'''


def get_single_numer(arr):
    set_arr = set()
    for ele in arr:
        if set_arr.__contains__(ele):
            set_arr.remove(ele)
        else:
            set_arr.add(ele)
    return set_arr.pop()

def get_single_number2(arr):
    single_number = arr[0]
    for i in range(1, len(arr)):
        single_number = single_number ^ arr[i]
    return single_number

if __name__ == '__main__':
    arr = [2, 3, 3, 2, 4]
    element = get_single_numer(arr)
    print(element)
