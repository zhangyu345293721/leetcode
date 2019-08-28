# encoding='utf-8'
'''
   author:zhangyu
   date:2019.8.28
   description:找出最大的连续子串
'''


def get_longest_consecutive(arr):
    if len(arr) <= 1:
        return len(arr)
    # 对数组进行排序
    arr.sort()
    max_length = 1
    count = 1
    for i in range(len(arr) - 1):
        if arr[i] + 1 == arr[i + 1]:
            count += 1
        else:
            if arr[i] != arr[i + 1]:
                count = 1
        if max_length < count:
            max_length = count
    return max_length


if __name__ == '__main__':
    arr = [2, 1, 3, 3, 4]
    max_length = get_longest_consecutive(arr)
    print(max_length)
