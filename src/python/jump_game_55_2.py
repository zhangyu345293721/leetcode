# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.29
   description:找出是否能跳出这个数组
'''


def get_judge_jump_arr(arr):
    max = 0
    length = len(arr)
    for index in range(1, length):
        if arr[index - 1] == 0 and index > arr[max] + max:
            return False
        if arr[max] - (index - max) < arr[index]:
            max = index
    return True


if __name__ == '__main__':
    arr = [2, 3, 1, 1, 4]
    flag = get_judge_jump_arr(arr)
    print(flag)
