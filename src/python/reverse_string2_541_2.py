# encoding='utf-8'

'''
   author:zhangyu
   description: 按照要求反转一个字符串2
   date:2019.8.19
'''
import re

def get_reverse_string(s, k):
        list = []
        sb = ''
        number = len(s) // k
        for i in range(number):
            list.append(s[i * k:i * k + k])
        if number * k < len(s):
            list.append(s[number * k:len(s)])
        for i in range(len(list)):
            if i % 2 == 0:
                sb += list[i][::-1]
            else:
                sb += list[i]
        return sb
 
def get_reverse_string2(s, k):
    # 当s字符串长度小于k的值
    if len(s) <= k:
        return s[::-1]
    # 当字符串长度在k和2k之间
    if len(s) > k and len(s) <= 2 * k:
        temp_str = s[0: k]
        return temp_str[::-1] + s[k:len(s)]
    # 当字符串长度大于2*k
    if len(s) > 2 * k:
        list = []
        sb = ''
        number = len(s) // k
        for i in range(number):
            list.append(s[i * k:i * k + k])
        if number * k < len(s):
            list.append(s[number * k:len(s)])
        for i in range(len(list)):
            if i % 2 == 0:
                sb += list[i][::-1]
            else:
                sb += list[i]
        return sb
    return '-1'
   
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
    revese_s = get_reverse_string(s, 2)
    print(revese_s)
