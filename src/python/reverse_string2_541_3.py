# encoding='utf-8'

'''
   author:zhangyu
   description: 按照要求反转一个字符串3
   date:2019.8.19
'''
import re


# 截取固定长度的字符串
def cut_text(text, lenth):
    textArr = re.findall('.{' + str(lenth) + '}', text)
    textArr.append(text[(len(textArr) * lenth):])
    return textArr


def get_reverse_str(arr):
    s = ''
    for i in range(len(arr)):
        if i % 2 == 0:
            s += arr[i][::-1]
        else:
            s += arr[i]
    return s


if __name__ == '__main__':
    s = 'abc'
    strs = cut_text(s, 2)
    new_s = get_reverse_str(strs)
    print(new_s)
