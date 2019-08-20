# encoding='utf-8'

'''
   author:zhangyu
   description:寻找遗失的数字
   date:2019.8.20
'''

def get_messing_number(arr):
    length = len(arr)
    s = set()
    for i in range(length + 1):
        s.add(i)
    for j in range(len(arr)):
        if s.__contains__(arr[j]):
            s.remove(arr[j])
    if len(s) == 1:
        return s.pop()
    else:
        return -1

if __name__ == '__main__':
    arr = [9, 6, 4, 2, 3, 5, 7, 0, 1]
    messing_number = get_messing_number(arr)
    print(messing_number)
