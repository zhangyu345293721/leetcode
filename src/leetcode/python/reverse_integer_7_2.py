# encoding='utf-8'

'''
    author:zhangyu
    date:2019.7.25
    description:把数字变成字符串，进入翻转
'''


def reverse_integer(num):
    if num == 0:
        return num
    if num > 0:
        return int(str(num)[::-1])
    else:
        return int('-' + str(num)[1:][::-1])

if __name__ == '__main__':
    number = reverse_integer(-1234)
    print(number)

