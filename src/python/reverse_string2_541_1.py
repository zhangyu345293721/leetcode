# encoding='utf-8'

'''
   author:zhangyu
   description: 按照要求反转一个字符串
   date:2019.8.19
'''


def get_reverse_string(s, k):
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


if __name__ == '__main__':
    s = 'abcdefg'
    revese_s = get_reverse_string(s, 2)
    print(revese_s)
